package io.ria.nailapp.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.ria.nailapp.Model.NailModel;

public class NailDBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    private static  final String DATABASE_NAME = "NAIL_DATABASE";
    private static  final String TABLE_NAME = "NAIL_TABLE";
    private static  final String COL_1 = "ID";
    private static  final String COL_2 = "FULLNAME";
    private static  final String COL_3 = "EMAIL";
    private static  final String COL_4 = "PHONE";
    private static  final String COL_5 = "TIME";
    private static  final String COL_6 = "SERVICE";
    private static  final String COL_7 = "TASK";
    private static  final String COL_8 = "STATUS";


    public NailDBHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "FULLNAME TEXT,EMAIL TEXT,PHONE TEXT,TIME TEXT, SERVICE TEXT, TASK TEXT, STATUS INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertTask(NailModel nailModel){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2 , nailModel.getFullName());
        values.put(COL_3,  nailModel.getEmail());
        values.put(COL_4,  nailModel.getPhone());
        values.put(COL_5,  nailModel.getTime());
        values.put(COL_6,  nailModel.getService());
        values.put(COL_7,  nailModel.getTask());
        values.put(COL_8 , 0);
        db.insert(TABLE_NAME , null , values);
    }

    public void updateStatus(int id , int status){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_8, status);
        db.update(TABLE_NAME , values , "ID=?" , new String[]{String.valueOf(id)});
    }

    public void deleteTask(int id ){
        db = this.getWritableDatabase();
        db.delete(TABLE_NAME , "ID=?" , new String[]{String.valueOf(id)});
    }

    public List<NailModel> getAllTasks(){

        db = this.getWritableDatabase();
        Cursor cursor = null;
        List<NailModel> modelList = new ArrayList<>();

        db.beginTransaction();
        try {
            cursor = db.query(TABLE_NAME , null , null , null , null , null , null);
            if (cursor !=null){
                if (cursor.moveToFirst()){
                    do {
                        NailModel nailModel = new NailModel();
                        nailModel.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
                        nailModel.setFullName(cursor.getString(cursor.getColumnIndex(COL_2)));
                        nailModel.setEmail(cursor.getString(cursor.getColumnIndex(COL_3)));
                        nailModel.setPhone(cursor.getString(cursor.getColumnIndex(COL_4)));
                        nailModel.setTime(cursor.getString(cursor.getColumnIndex(COL_5)));
                        nailModel.setService(cursor.getString(cursor.getColumnIndex(COL_6)));
                        nailModel.setTask(cursor.getString(cursor.getColumnIndex(COL_7)));
                        nailModel.setStatus(cursor.getInt(cursor.getColumnIndex(COL_8)));
                        modelList.add(nailModel);

                    }while (cursor.moveToNext());
                }
            }
        }finally {
            db.endTransaction();
            cursor.close();
        }
        return modelList;
    }

}
