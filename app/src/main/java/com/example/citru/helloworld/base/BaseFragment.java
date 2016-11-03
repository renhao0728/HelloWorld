package com.example.citru.helloworld.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public abstract class BaseFragment extends Fragment {
    protected RequestQueue mQueue;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mQueue = Volley.newRequestQueue(getActivity());
        initStatus();
    }

    protected void doJsonObjectReq(String url, Listener<JSONObject> ok,
                                   ErrorListener no) {
        mQueue.add(new JsonObjectRequest(url, null, ok, no));
    }


    public abstract void initStatus();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = setContentView(inflater, container);
        setupView(v);
        addListener(v);
        initData();
        return v;
    }

    public abstract void initData();

    public abstract void addListener(View v);

    public abstract View setContentView(LayoutInflater inflater,
                                        ViewGroup container);

    public abstract void setupView(View v);

    protected abstract String getPageName();

    protected void sendMsg(Handler handler, int what, int arg1, int arg2,
                           Object obj) {
        Message msg = handler.obtainMessage();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        msg.sendToTarget();
    }

    protected void goToOtherPage(Class<?> cls) {
        Intent i = new Intent(getActivity(), cls);
        startActivity(i);
    }

    protected void hideIM(View v) {
        if (v == null) {
            return;
        }

        InputMethodManager imm = (InputMethodManager) getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        IBinder ibinder = v.getWindowToken();
        if (ibinder != null) {
            imm.hideSoftInputFromWindow(ibinder, 0);
        }
    }
}
