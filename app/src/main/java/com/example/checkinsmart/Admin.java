package com.example.checkinsmart;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    private Button btn5,btn6,btn8,btn11,btn13,btn14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        String welcome = getIntent().getStringExtra("pos");
        Toast.makeText(this, "Welcome "+welcome, Toast.LENGTH_SHORT).show();
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn8= (Button) findViewById(R.id.button8);
        btn11= (Button) findViewById(R.id.button11);
        btn13 = (Button) findViewById(R.id.button13);
        btn14 = (Button) findViewById(R.id.button14);

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Admin.this,Newsfeed.class);
                startActivity(intent);

            }
        });

        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin.this,MainActivity5.class);
                startActivity(intent);
           }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Admin.this,MainActivity3.class);
                startActivity(intent);

            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Admin.this, Tips.class);
                intent.putExtra("name",welcome);
                intent.putExtra("role","1");
                startActivity(intent);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calender = new Intent(Admin.this, Calendera.class);
                startActivity(calender);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(Admin.this,MainActivity2.class);
               startActivity(intent);

            }
        });
    }
}