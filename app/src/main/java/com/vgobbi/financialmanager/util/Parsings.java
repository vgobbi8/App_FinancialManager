package com.vgobbi.financialmanager.util;

public class Parsings {
    public static EnumTypes.TipoDeConta IntToTipoDeConta(int value){
        switch (value){
            case 0:
                return EnumTypes.TipoDeConta.Corrente;
             case 1:
                 return EnumTypes.TipoDeConta.Poupanca;
             default:
                 return EnumTypes.TipoDeConta.Corrente;
        }
    }

    public static EnumTypes.TipoDeMovimento IntToTipoDeMovimento(int value){
        switch (value){
            case 0:
                return EnumTypes.TipoDeMovimento.Entrada;
            case 1:
                return EnumTypes.TipoDeMovimento.Saida;
            default:
                return EnumTypes.TipoDeMovimento.Entrada;
        }
    }
}
