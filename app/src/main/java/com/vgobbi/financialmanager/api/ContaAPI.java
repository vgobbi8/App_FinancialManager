package com.vgobbi.financialmanager.api;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.vgobbi.financialmanager.activity.AddMovtoActivity;
import com.vgobbi.financialmanager.model.Conta;
import com.vgobbi.financialmanager.singleton.CustomRequestQueue;
import com.vgobbi.financialmanager.util.EnumTypes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import com.vgobbi.financialmanager.util.Constantes;
public class ContaAPI {

    private IRequestEvents handler;
    private Context context;
    public ContaAPI(Context context, IRequestEvents handler){
        this.context = context;
        this.handler = handler;
    }
    public void POST(JSONObject json) {
        final Conta conta = new Conta();
        RequestQueue queue = CustomRequestQueue.getInstance().getRequestQueue();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                Constantes.URL_WEB_SERVICE + "Movimento", json,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject data)
                    {
                        try{
                            JSONObject jo = new JSONObject(data.toString());
                            conta.setAgencia(jo.getString("agencia"));
                            conta.setBanco(jo.getString("banco"));
                            conta.setDescricao(jo.getString("descricao"));
                            conta.setNrDaConta(jo.getString("nrDaconta"));
                            conta.setTipoDeConta(EnumTypes.TipoDeConta.Corrente);
                            conta.setId(jo.getLong("id"));

                            //atualizaTela(movimento);
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {

                    }
                });
    }

    public void GET() {
        RequestQueue queue = Volley.newRequestQueue(context);
        queue.start();
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET,
                Constantes.URL_WEB_SERVICE + "Contas",null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray data)
                    {
                        try{
                            JSONArray jo = new JSONArray(data.toString());
                            ArrayList<Conta> listaContas = new ArrayList<>();
                            for (int i = 0; i< jo.length();i++){
                                JSONObject json = jo.getJSONObject(i);
                                Conta conta = new Conta(json);
                                listaContas.add(conta);
                            }
                            handler.onResponse(listaContas);
                            //atualizaTela(movimento);
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                       // Toast.makeText(, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        queue.add(jsonObjectRequest);
    }

    public void GET(int id) {

    }
}
