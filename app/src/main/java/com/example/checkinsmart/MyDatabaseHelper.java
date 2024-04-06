package com.example.checkinsmart;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "EmployeeRecord.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "employee_details";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_PHONENUMBER = "phone_number";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_COMPANYNAME = "company_name";
    private static final String COLUMN_DESIGNATION = "designation";
    private static final String COLUMN_ROLE = "role";
    private static final String COLUMN_DOB = "date_of_birth";
    private static final String COLUMN_JOINDATE = "join_date";
    private static final String COLUMN_TERMINATEDDATE = "terminated_date";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " VARCHAR(255), " +
                COLUMN_NAME + " VARCHAR(255), " +
                COLUMN_EMAIL + " VARCHAR(255), " +
                COLUMN_PASSWORD + " VARCHAR(255), " +
                COLUMN_PHONENUMBER + " VARCHAR(255), " +
                COLUMN_ADDRESS + " VARCHAR(255), " +
                COLUMN_COMPANYNAME + " VARCHAR(255), " +
                COLUMN_DESIGNATION + " VARCHAR(255), " +
                COLUMN_ROLE + " VARCHAR(255), " +
                COLUMN_DOB + " VARCHAR(255), " +
                COLUMN_JOINDATE + " VARCHAR(255), " +
                COLUMN_TERMINATEDDATE + " VARCHAR(255));";
                db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    void addBook(String id, String name, String email, String password, String phonenumber
    ,String address, String companyname, String designation, String role, String dob,
                 String joindate, String terminateddate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID, id);
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_PHONENUMBER, phonenumber);
        cv.put(COLUMN_ADDRESS,address);
        cv.put(COLUMN_COMPANYNAME, companyname);
        cv.put(COLUMN_DESIGNATION, designation);
        cv.put(COLUMN_ROLE, role);
        cv.put(COLUMN_DOB, dob);
        cv.put(COLUMN_JOINDATE, joindate);
        cv.put(COLUMN_TERMINATEDDATE, terminateddate);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Employee Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
