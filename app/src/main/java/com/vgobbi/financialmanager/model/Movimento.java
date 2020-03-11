package com.vgobbi.financialmanager.model;

import com.vgobbi.financialmanager.util.EnumTypes;

import org.json.JSONObject;

import java.util.Date;

public class Movimento {
    private long id;
    private long contaId;
    private String descricao;
    private double valor;
    private Date dataMovimento;
    private EnumTypes.TipoDeMovimento tipoDeMovimento;

    public Movimento(){}

    public Movimento(JSONObject jsonObject){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContaId() {
        return contaId;
    }

    public void setContaId(long contaId) {
        this.contaId = contaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public EnumTypes.TipoDeMovimento getTipoDeMovimento() {
        return tipoDeMovimento;
    }

    public void setTipoDeMovimento(EnumTypes.TipoDeMovimento tipoDeMovimento) {
        this.tipoDeMovimento = tipoDeMovimento;
    }
}
