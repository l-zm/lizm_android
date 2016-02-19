package com.lizm.frame.utils;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;
import com.lizm.MyApplication;
import com.lizm.frame.base.BaseVolleyInterface;

import java.util.Map;

/**
 * HttpVolley
 * Created by lizm on 16/2/19.
 */
public class HttpVolley {
    public static StringRequest stringRequest;
//    public static Context context;

    /**
     * RequestGet
     */
    public static void RequestGet(String url, String tag, BaseVolleyInterface baseVolleyInterface) {

        // 取消当前请求,防止重复的请求
        MyApplication.getRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(Method.GET, url,
                baseVolleyInterface.successListener(), baseVolleyInterface.errorListener());
        stringRequest.setTag(tag);
        MyApplication.getRequestQueue().add(stringRequest);
        MyApplication.getRequestQueue().start();
    }

    /**
     * RequestPost
     */
    public static void RequestPost(String url, String tag,
                                   final Map<String, String> params, BaseVolleyInterface baseVolleyInterface) {
        // 取消当前请求,防止重复的请求
        MyApplication.getRequestQueue().cancelAll(tag);
        stringRequest = new StringRequest(url, baseVolleyInterface.successListener(),
                baseVolleyInterface.errorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        MyApplication.getRequestQueue().add(stringRequest);
        MyApplication.getRequestQueue().start();
    }
}
