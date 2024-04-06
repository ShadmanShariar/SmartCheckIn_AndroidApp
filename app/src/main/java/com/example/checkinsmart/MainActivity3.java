package com.example.checkinsmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity3 extends AppCompatActivity {
    private ListView myListVidew;
    MyDatabaseHelper myDB;
    ArrayList<String> book_id, book_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        myDB = new MyDatabaseHelper(MainActivity3.this);
        book_id = new ArrayList<>();
        book_title = new ArrayList<>();
        Cursor cursor = myDB.readAllData();

        while (cursor.moveToNext()) {
            book_id.add(cursor.getString(0));
            book_title.add(cursor.getString(1));
        }
        LinkedList<String> list  = new LinkedList<String>();

        for (int i = 0; i < book_id.size(); i++) {

            list.add("Name - "+book_title.get(i)+"     ID - "+book_id.get(i));

        }

        myListVidew = (ListView) findViewById(R.id.myListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
        myListVidew.setAdapter(arrayAdapter);
        myListVidew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = ((TextView) view).getText().toString().trim();
                String fnstr = "You Clicked On " + str;
                Toast.makeText(MainActivity3.this, fnstr, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity3.this,PieChartActivity.class);
                startActivity(intent);
            }
        });

    }
}
//    void storeDataInArrays(){
//        Cursor cursor = myDB.readAllData();
//        if(cursor.getCount() == 0){
//            empty_imageview.setVisibility(View.VISIBLE);
//            no_data.setVisibility(View.VISIBLE);
//        }else{
//            while (cursor.moveToNext()){
//                book_id.add(cursor.getString(0));
//                book_title.add(cursor.getString(1));
//            }
//            empty_imageview.setVisibility(View.GONE);
//            no_data.setVisibility(View.GONE);
//        }
//    }
