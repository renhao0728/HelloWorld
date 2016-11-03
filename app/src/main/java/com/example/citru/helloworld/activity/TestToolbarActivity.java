package com.example.citru.helloworld.activity;

        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v4.widget.SwipeRefreshLayout;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.GridView;
        import android.widget.Toast;

        import com.example.citru.helloworld.R;
        import com.example.citru.helloworld.base.BaseActivity;

        import java.util.ArrayList;
        import java.util.List;

public class TestToolbarActivity extends BaseActivity  implements SwipeRefreshLayout.OnRefreshListener{
    SwipeRefreshLayout mRefresh;
    private List<String> list = new ArrayList<>();
    private GridView gridView;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_text_toolbar);
    }

    @Override
    protected void initStatus() {

    }

    @Override
    protected void setupView() {
        mRefresh = (SwipeRefreshLayout) findViewById(R.id.text_refresh);
        gridView = (GridView) findViewById(R.id.gridView);

        for (int i = 0; i < 20; i++) {
            list.add("你好");
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        gridView.setAdapter(adapter);
    }

    @Override
    protected void addListener() {
        mRefresh.setOnRefreshListener(this);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRefresh.setRefreshing(false);
                Toast.makeText(mContext, "刷新成功", Toast.LENGTH_SHORT).show();
            }
        }, 2000);
    }
}
