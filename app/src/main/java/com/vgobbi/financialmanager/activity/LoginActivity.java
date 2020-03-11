package com.vgobbi.financialmanager.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.vgobbi.financialmanager.R;
import com.vgobbi.financialmanager.api.ContaAPI;
import com.vgobbi.financialmanager.api.IRequestEvents;
import com.vgobbi.financialmanager.model.Conta;
import com.vgobbi.financialmanager.util.Constantes;
import com.vgobbi.financialmanager.util.EnumTypes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void Entrar(View v){

        Intent i = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
        finish();

    }





}
