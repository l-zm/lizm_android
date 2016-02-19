package com.lizm;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 *
 * Created by lizm on 16/2/19.
 */
public class MyApplication extends Application {

    private static MyApplication myApplication;
    public static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        if(myApplication == null) {
            myApplication = this;
        }
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
