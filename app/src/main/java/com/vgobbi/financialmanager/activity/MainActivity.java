package com.vgobbi.financialmanager.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;

import com.vgobbi.financialmanager.R;
import com.vgobbi.financialmanager.adapter.ContasAdapter;
import com.vgobbi.financialmanager.api.ContaAPI;
import com.vgobbi.financialmanager.api.IRequestEvents;
import com.vgobbi.financialmanager.model.Conta;
import com.vgobbi.financialmanager.singleton.Contexto;
import com.vgobbi.financialmanager.util.RecyclerItemClickListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements IRequestEvents {
    RecyclerView recyclerContas;
    Toolbar toolbar;
    ContasAdapter adapter;
    ArrayList<Conta> listaContas =  new ArrayList<>();
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar_contas);
        setSupportActionBar(toolbar);
        handler = new Handler();
       // adapter = new ContasAdapter();
        recyclerContas = findViewById(R.id.recycler_contas);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerContas.setLayoutManager(layoutManager);
        recyclerContas.setHasFixedSize(true);
        recyclerContas.setAdapter(adapter);

        //Configurar evento de clique no recyclerview
        recyclerContas.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        this,
                        recyclerContas,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Conta usuarioSelecionado = listaContas.get( position );
                                Intent i = new Intent(MainActivity.this, ListagemActivity.class);
                             //   i.putExtra("chatContato", usuarioSelecionado );
                                startActivity( i );

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }
    public void add(View view){
        Intent i = new Intent(MainActivity.this,AddMovtoActivity.class);
        startActivity(i);
    }

    @Override
    public void onStart(){
        super.onStart();
        this.BuscarContas();
    }

    private void BuscarContas(){
        ContaAPI api = new ContaAPI(this,this);
        api.GET();
    }

    @Override
    public void onResponse(Object data){
        List<Conta> contas = (List<Conta>) data;
        adapter = new ContasAdapter(contas);
        recyclerContas.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onError(){}

    @Override
    public void onException(){}


}
