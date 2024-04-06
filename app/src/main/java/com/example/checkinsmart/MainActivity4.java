package com.example.checkinsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private TextView tv6;
private Button btn20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tv6 = (TextView) findViewById(R.id.textView6);

        btn20 = (Button) findViewById(R.id.button20);

        tv6.setText(getIntent().getStringExtra("post"));

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper3 db3 = new MyDatabaseHelper3(MainActivity4.this);
                db3.updateData(getIntent().getStringExtra("key"));
               // Toast.makeText(MainActivity4.this, getIntent().getStringExtra("key"), Toast.LENGTH_SHORT).show();

            }
        });

    }
}