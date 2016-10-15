package com.example.citru.helloworld.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.citru.helloworld.R;
import com.example.citru.helloworld.base.BaseActivity;
import com.example.citru.helloworld.db.DBManager;
import com.example.citru.helloworld.entity.SQliteEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqliteActivity extends BaseActivity {

    private ListView listView;
    private DBManager mgr;
    private Button btAdd;
    private Button btDelete;
    private Button btQuery;
    private Button btUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDate();

    }

    public void getDate() {
        //初始化DBManager
        mgr = new DBManager(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_sqlite);
    }

    @Override
    protected void initStatus() {

    }

    @Override
    protected void setupView() {
        listView = (ListView) findViewById(R.id.listView);
        btAdd = (Button) findViewById(R.id.bt_add);
        btDelete = (Button) findViewById(R.id.bt_delete);
        btQuery = (Button) findViewById(R.id.bt_query);
        btUpdate = (Button) findViewById(R.id.bt_update);


    }

    @Override
    protected void addListener() {
        btAdd.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btQuery.setOnClickListener(this);
        btUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_add:
                add();
                break;
            case R.id.bt_delete:
                delete();
                break;
            case R.id.bt_query:
                query();
                break;
            case R.id.bt_update:
                update();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //应用的最后一个Activity关闭时应释放DB
        mgr.closeDB();
    }
//    增加
    public void add() {
        ArrayList<SQliteEntity> persons = new ArrayList<SQliteEntity>();

        SQliteEntity person1 = new SQliteEntity("李磊", 22);


        persons.add(person1);


        mgr.add(persons);
    }
    //此处是根据名字修改年龄，可以根据ID
    public void update() {
        SQliteEntity person = new SQliteEntity();
        person.name = "Jane";
        person.age = 99;
        mgr.updateAge(person);
    }
//    年龄大于等于30岁的都删除了，可以根据ID
    public void delete() {
        SQliteEntity person = new SQliteEntity();
        person.age = 30;
        mgr.deleteOldPerson(person);
    }
    //    查询
    public void query() {
        List<SQliteEntity> persons = mgr.query();
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (SQliteEntity person : persons) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("name", person.name);
            map.put("age", person.age+"");
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
                new String[]{"name", "age"}, new int[]{android.R.id.text1, android.R.id.text2});
        listView.setAdapter(adapter);
    }

}
