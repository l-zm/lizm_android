package com.lizm.frame.base;

import android.content.Context;

import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

/**
 * BaseVolleyInterface
 * Created by lizm on 16/2/19.
 */
public abstract class BaseVolleyInterface {

    public Context mContext;
    public static Listener<String> mListener;
    public static ErrorListener mErrorListener;

    public BaseVolleyInterface(Context context, Listener<String> listener,
                               ErrorListener errorListener) {
        this.mContext = context;
        this.mListener = listener;
        this.mErrorListener = errorListener;
    }

    /**
     * 成功的监听
     */
    public Listener<String> successListener() {
        mListener = new Listener<String>() {
            @Override
            public void onResponse(String response) {
                onHttpSuccess(response);
            }
        };
        return mListener;
    }
    public abstract void onHttpSuccess(String result);

    /**
     * 失败的监听
     */
    public ErrorListener errorListener() {
        mErrorListener = new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                onHttpError(volleyError);
            }
        };
        return mErrorListener;
    }
    public abstract void onHttpError(VolleyError volleyError);
}
