package com.example.citru.helloworld.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by citrus on 2016/8/15.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sq_test.db";
    private static final int DATABASE_VERSION = 1;

    //调用父类构造器
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * 当数据库首次创建时执行该方法，一般将创建表等初始化操作放在该方法中执行.
     * 重写onCreate方法，调用execSQL方法创建表
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE helloworldtable (_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, age INTEGER)");
        db.execSQL("create table if not exists helloworldtable("
                + "_id integer primary key autoincrement,"
                + "name varchar,"
                + "age integer,express_img BLOB)");
    }
    //如果DATABASE_VERSION值被改为2,系统发现现有数据库版本不同,即会调用onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
// 数据库更新的语句
        db.execSQL("ALTER TABLE person ADD COLUMN other STRING");
    }
}
