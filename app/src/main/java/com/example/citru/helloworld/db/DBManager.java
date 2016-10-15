package com.example.citru.helloworld.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.citru.helloworld.entity.SQliteEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by citrus on 2016/8/15.
 */
public class DBManager {
    private DBHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        helper = new DBHelper(context);
        //因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);
        //所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
        db = helper.getWritableDatabase();
    }

    /**
     * add persons
     * @param persons
     */
    public void add(List<SQliteEntity> persons) {
        db.beginTransaction();  //开始事务
        try {
            for (SQliteEntity person : persons) {
                db.execSQL("INSERT INTO helloworldtable VALUES(null, ?, ?)", new Object[]{person.name, person.age});
            }
            db.setTransactionSuccessful();  //设置事务成功完成
        } finally {
            db.endTransaction();    //结束事务
        }
    }

    /**
     * update person's age
     * @param person
     */
//    根据名字修改年龄，可以根据ID
    public void updateAge(SQliteEntity person) {
        ContentValues cv = new ContentValues();
        cv.put("age", person.age);
        db.update("helloworldtable", cv, "name = ?", new String[]{person.name});
    }

    /**
     * delete old person
     * @param person
     */
    public void deleteOldPerson(SQliteEntity person) {
        db.delete("helloworldtable", "age >= ?", new String[]{String.valueOf(person.age)});
    }

    /**
     * query all persons, return list
     * @return List<Person>
     */
    public List<SQliteEntity> query() {
        ArrayList<SQliteEntity> persons = new ArrayList<SQliteEntity>();
        Cursor c = queryTheCursor();
        while (c.moveToNext()) {
            SQliteEntity person = new SQliteEntity();
            person._id = c.getInt(c.getColumnIndex("_id"));
            person.name = c.getString(c.getColumnIndex("name"));
            person.age = c.getInt(c.getColumnIndex("age"));
            persons.add(person);
        }
        c.close();
        return persons;
    }

    /**
     * query all persons, return cursor
     * @return  Cursor
     */
    public Cursor queryTheCursor() {
        Cursor c = db.rawQuery("SELECT * FROM helloworldtable", null);
        return c;
    }

    /**
     * close database
     */
    public void closeDB() {
        db.close();
    }

}
