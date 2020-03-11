package com.vgobbi.financialmanager.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.vgobbi.financialmanager.R;
import com.vgobbi.financialmanager.model.Movimento;

import java.util.List;

public class MovimentosAdapter extends RecyclerView.Adapter<MovimentosAdapter.MyViewHolder> {
    List<Movimento> listaClientes;
    public MovimentosAdapter(List<Movimento> clientes){
        this.listaClientes = clientes;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_movimentos, parent, false);
        return new MyViewHolder(itemLista);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movimento movimento = listaClientes.get(position);
        //holder.descricao.setText( cliente.getNome() );
       // holder.telefone.setText(cliente.getTelefone());
       // Log.i("clienteAdapter", cliente.getNome());
    }
    @Override
    public int getItemCount() {
        return this.listaClientes.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView descricao;
        TextView ag;
        TextView nr;
        public MyViewHolder(View itemView) {
            super(itemView);
            descricao = itemView.findViewById(R.id.txtAgencia);
            ag = itemView.findViewById(R.id.txtAgencia);
            nr = itemView.findViewById(R.id.txtNr);
        }
    }
}
