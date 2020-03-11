package com.vgobbi.financialmanager.model;

import android.content.Context;

import com.vgobbi.financialmanager.util.EnumTypes;

import org.json.JSONObject;

import java.util.ArrayList;

public class Conta {
    private long id;
    private String banco;
    private String agencia;
    private String nrDaConta;
    private String descricao;
    private EnumTypes.TipoDeConta tipoDeConta;
    private ArrayList<Movimento> listaMovimentos;

    public Conta(){}
    public Conta(JSONObject json){
        try{
            this.id = (json.getLong("id"));
            this.agencia = (json.getString(("agencia")));
            this.nrDaConta = (json.getString("nrDaConta"));
            this.banco = (json.getString("banco"));
            this.descricao = (json.getString("descricao"));
            this.tipoDeConta = (EnumTypes.TipoDeConta.Poupanca);
        }catch (Exception ex){
            this.id = 0l;
            this.agencia = "";
            this.nrDaConta = "";
            this.banco = "";
            this.descricao = "";
            this.tipoDeConta = (EnumTypes.TipoDeConta.Poupanca);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNrDaConta() {
        return nrDaConta;
    }

    public void setNrDaConta(String nrDaConta) {
        nrDaConta = nrDaConta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        descricao = descricao;
    }

    public EnumTypes.TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(EnumTypes.TipoDeConta tipoDeConta) {
        tipoDeConta = tipoDeConta;
    }

    public ArrayList<Movimento> getListaMovimentos() {
        return listaMovimentos;
    }

    public void setListaMovimentos(ArrayList<Movimento> listaMovimentos) {
        this.listaMovimentos = listaMovimentos;
    }
}
