package com.vgobbi.financialmanager.util;

import com.android.volley.*;
import com.android.volley.toolbox.*;



import org.json.*;

import java.io.*;
import java.util.*;

public class CustomJsonObjectRequest extends Request<JSONObject> {

    Response.Listener<JSONObject> response;
    private Map<String, String> params;
    private Map<String, String> headers;

    public CustomJsonObjectRequest(String url, Response.ErrorListener listener)
    {
        super(url, listener);

    }

    public CustomJsonObjectRequest(int method,
                                   String url,
                                   Map<String, String> params,
                                   Response.Listener<JSONObject> response,
                                   Response.ErrorListener listener)
    {
        super(method, url, listener);
        this.params = params;
        this.response = response;
    }


    public Map<String, String> getParams() throws AuthFailureError
    {
        return params;
    }



    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response)
    {
        try
        {
            String js = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return (Response.success(new JSONObject(js), HttpHeaderParser.parseCacheHeaders(response)));
        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        catch(JSONException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void deliverResponse(JSONObject response)
    {
        this.response.onResponse(response);
    }
}
