package com.vgobbi.financialmanager.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.vgobbi.financialmanager.R;
import com.vgobbi.financialmanager.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContasAdapter extends RecyclerView.Adapter<ContasAdapter.MyViewHolder>{
    List<Conta> listaContas;
    public ContasAdapter(List<Conta> contas){
        this.listaContas = contas;
    }
    @Override
    public ContasAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_contas, parent, false);
        return new ContasAdapter.MyViewHolder(itemLista);
    }
    @Override
    public void onBindViewHolder(ContasAdapter.MyViewHolder holder, int position) {
        Conta conta = listaContas.get(position);
        holder.descricao.setText( conta.getDescricao() );
        holder.ag.setText(conta.getAgencia());
        holder.nr.setText(conta.getNrDaConta());
        Log.i("contaAdapter", conta.getDescricao());
    }
    @Override
    public int getItemCount() {
        return this.listaContas.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView descricao;
        TextView ag;
        TextView nr;
        public MyViewHolder(View itemView) {
            super(itemView);
            descricao = itemView.findViewById(R.id.adptconta_txt_descricao);
            ag = itemView.findViewById(R.id.txt_adapter_ag);
            nr = itemView.findViewById(R.id.adptconta_txt_nr);
        }
    }
}
