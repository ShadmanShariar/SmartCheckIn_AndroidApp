package com.example.checkinsmart;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

class MyDatabaseHelper3 extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Blog.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "blog";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_BLOG = "blog";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_APPROVE = "approve";

    MyDatabaseHelper3(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " VARCHAR(255), " +
                COLUMN_EMAIL + " VARCHAR(255), " +
                COLUMN_TITLE + " VARCHAR(255), " +
                COLUMN_APPROVE + " VARCHAR(255), " +
                COLUMN_BLOG + " TEXT, " +
                COLUMN_CATEGORY + " VARCHAR(255));";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addBlog(String email,String title  ,String blog, String category, String approve){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID,(email+"#"+title));
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_BLOG, blog);
        cv.put(COLUMN_CATEGORY, category);
        cv.put(COLUMN_APPROVE,approve);

        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Post Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    void updateData(String key){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_APPROVE,"1");
        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{key});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Checkout Submitted !", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME +" WHERE approve='1'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    Cursor readAllData2(){
        String query = "SELECT * FROM " + TABLE_NAME +" WHERE approve='0'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
