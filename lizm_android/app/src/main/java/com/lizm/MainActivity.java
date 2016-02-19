package com.lizm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.lizm.frame.base.BaseVolleyInterface;
import com.lizm.frame.utils.HttpVolley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volley_get();
    }

    private void volley_get() {
        String url = "http://apis.juhe.cn/mobile/get?phone=13429667914&key=您申请的KEY";
        HttpVolley.RequestGet(url, "abcTag", new BaseVolleyInterface(this,
                BaseVolleyInterface.mListener, BaseVolleyInterface.mErrorListener) {
            @Override
            public void onHttpSuccess(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onHttpError(VolleyError volleyError) {
                Toast.makeText(MainActivity.this, volleyError.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
