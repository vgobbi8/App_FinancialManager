package com.vgobbi.financialmanager.singleton;

import android.content.Context;

public class Contexto {
    private Context _context;
    private Contexto() {
    }

    private static Contexto contexto;

    public static Contexto getInstance() {
        if (contexto == null) {
            newInstance();
        }
        return contexto;
    }

    private static void init() {
        contexto = new Contexto();
    }

    public static void newInstance() {
        init();
    }
}
