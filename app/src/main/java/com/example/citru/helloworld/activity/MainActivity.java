package com.example.citru.helloworld.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.citru.helloworld.R;
import com.example.citru.helloworld.adapter.ImageAdapter;
import com.example.citru.helloworld.base.BaseActivity;
import com.example.citru.helloworld.entity.BannersEntity;
import com.example.citru.helloworld.entity.Json2Entity;
import com.example.citru.helloworld.sercive.MyService;
import com.example.citru.helloworld.ui.CircleFlowIndicator;
import com.example.citru.helloworld.ui.ViewFlow;
import com.example.citru.helloworld.util.PhoneUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends BaseActivity {
    private TextView tvLoginQQ;
    private TextView tvLoginWeiBo;
    private ViewFlow viewFlow;
    private int ScreenWith;
    private Button bt;
    private Button btBind,btStar;
    private Button btStopStar;
    private Button btStopBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenWith = PhoneUtil.getScreenWidth(mContext);
        int picH = (int) (ScreenWith * 1.0f / 2);
        FrameLayout.LayoutParams linearParams = (FrameLayout.LayoutParams) viewFlow
                .getLayoutParams();
        linearParams.height = picH;
        linearParams.width = ScreenWith;
        viewFlow.setLayoutParams(linearParams);

        BannersEntity barr= new BannersEntity();
        ArrayList<BannersEntity> list = new ArrayList<>();
        barr.imgPath="http://img2.imgtn.bdimg.com/it/u=2955762202,755888452&fm=21&gp=0.jpg";
        barr.name="ww";
        list.add(barr);
        barr= new BannersEntity();
        barr.imgPath="http://img5.imgtn.bdimg.com/it/u=1190949324,347226383&fm=21&gp=0.jpg";
        barr.name="ww";
        list.add(barr);
        barr= new BannersEntity();
        barr.imgPath="http://img5.imgtn.bdimg.com/it/u=603621955,1179636658&fm=21&gp=0.jpg";
        barr.name="ww";
        list.add(barr);
        getData();
        // 广告轮播图
        viewFlow.setAdapter(new ImageAdapter(mContext, list, ScreenWith));

        viewFlow.setmSideBuffer(list.size()); // 设置图片

        // 轮播图的圆点
        CircleFlowIndicator indic = (CircleFlowIndicator) findViewById(R.id.viewflowindic);
        viewFlow.setFlowIndicator(indic);
        viewFlow.setTimeSpan(3000);
        viewFlow.setSelection(50); // 设置初始位置
        if (list.size() > 1) {
            viewFlow.startAutoFlowTimer(); // 启动自动播放
        }
    }
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    public void getData() {
        String url = "http://gc.ditu.aliyun.com/regeocoding?l=39.938133,116.395739&type=001";


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {


                    @Override
                    public void onResponse(JSONObject obj) {
                        try {
                            Json2Entity str;
                            str = getListEntity(obj.toString());
//                            Log.i("TAG",str.address+str.cityName+str.lat+str.lon+str.alevel+str.level);
                            Log.i("TAG", "type" + str.addrList.get(0).type + ";" + str.queryLocation.get(0).toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            Log.i("TAG", "异常");
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError arg0) {
                Log.i("TAG", "失败");


            }
        });
        mQueue.add(jsonObjReq);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initStatus() {

    }

    @Override
    protected void setupView() {
        tvLoginQQ = (TextView) findViewById(R.id.main_login_qq);
        tvLoginWeiBo = (TextView) findViewById(R.id.main_login_weibo);

        viewFlow = (ViewFlow) findViewById(R.id.vp_village_detail_banner);
        bt = (Button) findViewById(R.id.bt_sq);

        btStar = (Button) findViewById(R.id.bt_star);
        btBind = (Button) findViewById(R.id.bt_bind);

        btStopStar = (Button) findViewById(R.id.bt_stop_s_s);
        btStopBind = (Button) findViewById(R.id.bt_stop_b_s);
    }

    @Override
    protected void addListener() {
        tvLoginQQ.setOnClickListener(this);
        tvLoginWeiBo.setOnClickListener(this);
        btStar.setOnClickListener(this);
        btBind.setOnClickListener(this);
        bt.setOnClickListener(this);
        btStopStar.setOnClickListener(this);
        btStopBind.setOnClickListener(this);
    }

    public Json2Entity getListEntity(String jsonString) {
        Json2Entity listEntity = new Json2Entity();
        Gson gson = new Gson();
        listEntity = gson.fromJson(jsonString,
                new TypeToken<Json2Entity>() {
                }.getType());

        return listEntity;
    }

    @Override
    public void onClick(View view) {
        Intent serviceIntent=new Intent(this,MyService.class);
        serviceIntent.setAction(MyService.ACTION);

        switch (view.getId()) {

            case R.id.main_login_qq:
                Intent i23454 = new Intent(mContext, ContentActivity.class);
                startActivity(i23454);
                break;

            case R.id.main_login_weibo:
                Intent ifsdfdsfs = new Intent(mContext, GuangboActivity.class);
                startActivity(ifsdfdsfs);
                break;


            case R.id.bt_sq:
                Intent i3 = new Intent(mContext, SqliteActivity.class);
                startActivity(i3);
                break;


            case R.id.bt_star:
                startService(serviceIntent);
                break;
            case R.id.bt_bind:
                bindService(serviceIntent,conn,BIND_AUTO_CREATE);
                break;
            case R.id.bt_stop_s_s:
                stopService(serviceIntent);
                break;
            case R.id.bt_stop_b_s:

                break;
        }
    }


}
