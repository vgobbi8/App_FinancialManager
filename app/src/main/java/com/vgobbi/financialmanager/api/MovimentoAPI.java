package com.vgobbi.financialmanager.api;

import android.content.Context;
import android.view.textclassifier.TextLinks;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.vgobbi.financialmanager.util.Constantes;

import org.json.JSONObject;

import java.lang.reflect.Method;

public class MovimentoAPI {
    private Context context;
    private IRequestEvents handler;

    public MovimentoAPI(Context _context, IRequestEvents _handler) {
        this.context = _context;
        this.handler = _handler;
    }

    public void POST(JSONObject json) {
        RequestQueue queue = Volley.newRequestQueue(this.context);
        queue.start();
        JsonObjectRequest novoMovimento = new JsonObjectRequest(Request.Method.POST, Constantes.URL_WEB_SERVICE,
                                                                json, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getLong("id") > 0){
                        handler.onResponse(response);
                    }
                }catch (Exception ex){
                    handler.onException();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        handler.onError();
                    }
                });
        queue.add(novoMovimento);
    }
}