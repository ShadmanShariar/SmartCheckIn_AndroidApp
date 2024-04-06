package com.example.checkinsmart;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

class MyDatabaseHelper2 extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Time.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "timeschedule";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_STIME = "stime";
    private static final String COLUMN_ETIME = "etime";
    private static final String COLUMN_DATE = "date";

    MyDatabaseHelper2(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " VARCHAR(255), " +
                COLUMN_EMAIL + " VARCHAR(255), " +
                COLUMN_STIME + " VARCHAR(255), " +
                COLUMN_ETIME + " VARCHAR(255), " +
                COLUMN_DATE + " VARCHAR(255));";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addBook(String email, String stime, String etime, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_ID, email+date);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_STIME, stime);
        cv.put(COLUMN_ETIME, etime);
        cv.put(COLUMN_DATE,date);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Attendance Submitted !", Toast.LENGTH_SHORT).show();
        }
    }

    void updateData(String email, String etime, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_ETIME, etime);
        cv.put(COLUMN_DATE, date);
        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{email+date});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Checkout Submitted !", Toast.LENGTH_SHORT).show();
        }

    }

    Cursor readAllData(String em,String date){
        String query = "SELECT * FROM " + TABLE_NAME +" WHERE email='"+em+"' AND date='"+date+"'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}