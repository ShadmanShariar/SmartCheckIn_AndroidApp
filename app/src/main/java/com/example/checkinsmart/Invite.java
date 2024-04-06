package com.example.checkinsmart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Invite extends AppCompatActivity {

    private EditText ed;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
        btn= (Button)findViewById(R.id.button7);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ed = (EditText) findViewById(R.id.editTextText);
                String[] TO_EMAILS = {ed.getText().toString().trim()};

     //         String[] CC = {"emailthree@example.com"};
     //         String[] BCC = {"emailfour@example.com"};

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, TO_EMAILS);
     //         intent.putExtra(Intent.EXTRA_CC, CC);
     //         intent.putExtra(Intent.EXTRA_BCC, BCC);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Invitation For join Out Attendance System");
                intent.putExtra(Intent.EXTRA_TEXT, "Congrats ! Welcome to our team");
                startActivity(Intent.createChooser(intent, "Choose your email client"));

              }
        });



    }
}