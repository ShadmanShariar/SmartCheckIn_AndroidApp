package com.example.checkinsmart;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button loginbutton;
    private EditText email, password;
    private MyDatabaseHelper myDB2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        loginbutton = (Button) findViewById(R.id.button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String chkemail = email.getText().toString().trim();
                String chkpassword = password.getText().toString().trim();

                if (chkemail.equals("") || chkpassword.equals("") || chkpassword.length() < 6) {

                    Toast.makeText(MainActivity.this, "Enter Valid Email & Password", Toast.LENGTH_SHORT).show();

                } else {

                    if (chkemail.equals("rahim@gmail.com")) {
                        Intent intent = new Intent(MainActivity.this, Admin.class);
                        intent.putExtra("pos", email.getText().toString().trim().split("@")[0]);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, User.class);
                        intent.putExtra("pos", email.getText().toString().trim().split("@")[0]);
                        intent.putExtra("posmail", email.getText().toString().trim());
                        startActivity(intent);
                    }

                }
            }
        });


    }
}