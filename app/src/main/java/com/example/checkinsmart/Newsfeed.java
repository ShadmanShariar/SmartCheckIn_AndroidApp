package com.example.checkinsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Newsfeed extends AppCompatActivity {

    private ListView myListVidew2;
    MyDatabaseHelper3 myDB;
    ArrayList<String> email,title,blog;
    public  static HashMap<String,String> map = new HashMap<String,String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        myDB = new MyDatabaseHelper3(Newsfeed.this);
        email = new ArrayList<>();
        title = new ArrayList<>();
        blog = new ArrayList<>();
        Cursor cursor = myDB.readAllData();

        while (cursor.moveToNext()) {
            email.add(cursor.getString(1));
            title.add(cursor.getString(2));
            blog.add(cursor.getString(4));
        }
        LinkedList<String> list  = new LinkedList<String>();

        for (int i = 0; i < email.size(); i++) {

            list.add("Author - "+email.get(i)+"\n"+"Title - "+title.get(i));
            map.put("Author - "+email.get(i)+"\n"+"Title - "+title.get(i),"\n\nAuthor - "+email.get(i)+"\n\n"+"Title - "+title.get(i)+"\n\n"+blog.get(i));

        }
        myListVidew2 = (ListView) findViewById(R.id.myListView2);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
        myListVidew2.setAdapter(arrayAdapter);
        myListVidew2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = ((TextView) view).getText().toString().trim();
                String fnstr = "You Clicked On " + str;
                Toast.makeText(Newsfeed.this, fnstr, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Newsfeed.this,MainActivity4.class);
                intent.putExtra("post",map.get(str));
                startActivity(intent);
            }
        });


    }
}