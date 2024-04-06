package com.example.checkinsmart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Tips extends AppCompatActivity {
private RadioGroup rg;
private RadioButton rb;
private EditText ed,tb;
private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        ed = (EditText) findViewById(R.id.blog);
        btn = (Button) findViewById(R.id.button12);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        tb = (EditText) findViewById(R.id.titleblog);
                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = rg.getCheckedRadioButtonId();
                rb = (RadioButton)findViewById(id);

                MyDatabaseHelper3 myDB = new MyDatabaseHelper3(Tips.this);
                String tmp = getIntent().getStringExtra("name");
                String tmp2 = getIntent().getStringExtra("role").toString().trim();
                myDB.addBlog(tmp,tb.getText().toString().trim(),ed.getText().toString().trim(),rb.getText().toString().trim(),tmp2);

                ed.setText("");
                rb.setText("");

            }
        });

    }
    public void buttonBold(View view){
        ed = (EditText) findViewById(R.id.blog);
        Spannable spannableString = new SpannableStringBuilder(ed.getText());
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),
                ed.getSelectionStart(),
                ed.getSelectionEnd(),
                0);

        ed.setText(spannableString);
    }
    public void buttonItalics(View view){
        Spannable spannableString = new SpannableStringBuilder(ed.getText());
        spannableString.setSpan(new StyleSpan(Typeface.ITALIC),
                ed.getSelectionStart(),
                ed.getSelectionEnd(),
                0);

        ed.setText(spannableString);

    }
    public void buttonUnderline(View view){
        Spannable spannableString = new SpannableStringBuilder(ed.getText());
        spannableString.setSpan(new UnderlineSpan(),
                ed.getSelectionStart(),
                ed.getSelectionEnd(),
                0);

        ed.setText(spannableString);
    }
    public void buttonNoFormat(View view){
        String stringText = ed.getText().toString();
        ed.setText(stringText);
    }
    public void buttonAlignmentLeft(View view){
        ed.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        Spannable spannableString = new SpannableStringBuilder(ed.getText());
        ed.setText(spannableString);
    }

    public void buttonAlignmentCenter(View view){
        ed.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Spannable spannableString = new SpannableStringBuilder(ed.getText());
        ed.setText(spannableString);
    }

    public void buttonAlignmentRight(View view){
        ed.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        Spannable spannableString = new SpannableStringBuilder(ed.getText());
        ed.setText(spannableString);
    }
}