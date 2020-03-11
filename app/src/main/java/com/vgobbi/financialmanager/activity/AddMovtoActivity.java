package com.vgobbi.financialmanager.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.vgobbi.financialmanager.R;
import com.vgobbi.financialmanager.model.Movimento;
import com.vgobbi.financialmanager.util.CustomJsonObjectRequest;
import com.vgobbi.financialmanager.singleton.CustomRequestQueue;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AddMovtoActivity extends AppCompatActivity {

    Movimento movimento;
    Button button;
    TextInputEditText txtCod, txtDesc,txtValor;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movto);
        movimento = new Movimento();
        this.txtCod = findViewById(R.id.txtCodigo);
        this.txtDesc = findViewById(R.id.txtDesc);
        this.txtValor = findViewById(R.id.txtValor);
        handler = new Handler();
        txtCod.setText("12");
        txtDesc.setText("Descrição");
        txtValor.setText("100");
    }

    public void Enviar(View view){

      //  this.movimento.setCodigo(Integer.parseInt(txtCod.getText().toString()));
        this.movimento.setDescricao(txtDesc.getText().toString());
        this.movimento.setValor(Double.parseDouble(txtValor.getText().toString()));
    //    Req();




    }


    public void atualizaTela(final Movimento movimento){
        handler.post(new Runnable() {
            @Override
            public void run() {
              //  txtCod.setText(String.valueOf(movimento.getCodigo()));
                txtDesc.setText(movimento.getDescricao());
                txtValor.setText(String.valueOf(movimento.getValor()));
            }
            });
        }
    }

