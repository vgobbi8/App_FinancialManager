package com.vgobbi.financialmanager.api;

import org.json.JSONArray;
import org.json.JSONObject;

public interface IRequestEvents {
    public void onResponse(Object data);
    public void onError();
    public void onException();
}
