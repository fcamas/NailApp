package io.ria.nailapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.ria.nailapp.Model.NailCustomerModel;

public class DBNailCustomerHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    private static  final String DATABASE_NAME = "USER_DATABASE";
    private static  final String TABLE_NAME = "USER_TABLE";
    private static  final String COL_1 = "ID";
    private static  final String COL_2 = "FULLNAME";
    private static  final String COL_3 = "EMAIL";
    private static  final String COL_4 = "PHONE";
    private static  final String COL_5 = "APPOINMENTDATE";
    private static  final String COL_6 = "OP1";
    private static  final String COL_7 = "OP2";
    private static  final String COL_8 = "OP3";
    private static  final String COL_9 = "OP4";

    public DBNailCustomerHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FULLNAME TEXT, " +
                "EMAIL TEXT," +
                "PHONE TEXT," +
                "OP1 TEXT," +
                "OP2 TEXT,"+
                "OP3 TEXT,"+
                "OP4 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertInCard(NailCustomerModel model){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2 , model.getFullName());
        values.put(COL_3 , model.getEmail());
        values.put(COL_4 , model.getCellPhone());
        values.put(COL_5 , model.getAppointmentDate());
        values.put(COL_6 , model.getOptionOne());
        values.put(COL_7 , model.getOptionTwo());
        values.put(COL_8 , model.getOptionThree());
        values.put(COL_8 , model.getOptionFour());
        db.insert(TABLE_NAME , null , values);
    }

    public void updateCardDate(int id , String newDate){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_5 , newDate);
        db.update(TABLE_NAME , values , "ID=?" , new String[]{String.valueOf(id)});
    }

    public void updateCardCellPhone(int id , int newCellPhone){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_3 , newCellPhone);
        db.update(TABLE_NAME , values , "ID=?" , new String[]{String.valueOf(id)});
    }

    public void deleteTask(int id ){
        db = this.getWritableDatabase();
        db.delete(TABLE_NAME , "ID=?" , new String[]{String.valueOf(id)});
    }

    public List<NailCustomerModel> getAllTasks(){

        db = this.getWritableDatabase();
        Cursor cursor = null;
        List<NailCustomerModel> modelList = new ArrayList<>();

        db.beginTransaction();
        try {
            cursor = db.query(TABLE_NAME , null , null , null , null , null , null);
            if (cursor !=null){
                if (cursor.moveToFirst()){
                    do {
                        NailCustomerModel card = new NailCustomerModel();
                        card.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
                        card.setFullName(cursor.getString(cursor.getColumnIndex(COL_2)));
                        card.setEmail(cursor.getString(cursor.getColumnIndex(COL_3)));
                        card.setCellPhone(cursor.getString(cursor.getColumnIndex(COL_4)));
                        card.setAppointmentDate(cursor.getString(cursor.getColumnIndex(COL_5)));
                        card.setOptionOne(cursor.getString(cursor.getColumnIndex(COL_6)));
                        card.setOptionTwo(cursor.getString(cursor.getColumnIndex(COL_7)));
                        card.setOptionThree(cursor.getString(cursor.getColumnIndex(COL_8)));
                        card.setOptionFour(cursor.getString(cursor.getColumnIndex(COL_9)));
                        modelList.add(card);

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
