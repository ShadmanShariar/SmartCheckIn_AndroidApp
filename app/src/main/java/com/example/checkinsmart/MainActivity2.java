package com.example.checkinsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText id, name, email, password, phonenumber,address, companyname,designation,role,
    dob,joindate,terminateddate;
   private Button add_button;
    private TextView tvinv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvinv = (TextView) findViewById(R.id.textView4);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        phonenumber = (EditText) findViewById(R.id.phonenumber);
        address = (EditText) findViewById(R.id.address);
        companyname = (EditText) findViewById(R.id.companyname);
        designation = (EditText) findViewById(R.id.designation);
        role = (EditText) findViewById(R.id.role);
        dob = (EditText) findViewById(R.id.dob);
        joindate = (EditText) findViewById(R.id.joindate);
        terminateddate = (EditText) findViewById(R.id.terminateddate);

        tvinv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity2.this,Invite.class);
                startActivity(intent);

            }
        });

            add_button = findViewById(R.id.add_button);
            add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sid = id.getText().toString().trim();
                String sname = name.getText().toString().trim();
                String semail = email.getText().toString().trim();
                String spassword = password.getText().toString().trim();
                String sphonenumber = phonenumber.getText().toString().trim();
                String saddress = address.getText().toString().trim();
                String scompanyname = companyname.getText().toString().trim();
                String sdesignation = designation.getText().toString().trim();
                String srole = role.getText().toString().trim();
                String sdob = dob.getText().toString().trim();
                String sjoindate = joindate.getText().toString().trim();
                String sterminateddate = terminateddate.getText().toString().trim();

                if(sid.equals("")||sname.equals("")||semail.equals("")||spassword.equals("")||
                        sphonenumber.equals("")||saddress.equals("")||scompanyname.equals("")||sdesignation.equals("")||
                        srole.equals("")||sdob.equals("")||sjoindate.equals("")||sterminateddate.equals("")){

                    Toast.makeText(MainActivity2.this, "Fill All The Inputs", Toast.LENGTH_SHORT).show();

                }else{

                    MyDatabaseHelper myDB = new MyDatabaseHelper(MainActivity2.this);
                    myDB.addBook(sid, sname,semail,spassword,sphonenumber,saddress,scompanyname,sdesignation,
                            srole,sdob,sjoindate,sterminateddate);
                    id.setText("");
                    name.setText("");
                    email.setText("");
                    password.setText("");
                    phonenumber.setText("");
                    address.setText("");
                    companyname.setText("");
                    designation.setText("");
                    role.setText("");
                    dob.setText("");
                    joindate.setText("");
                    terminateddate.setText("");

                }
            }
        });
    }
}