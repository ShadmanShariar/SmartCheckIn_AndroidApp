package com.example.checkinsmart;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
public class User extends AppCompatActivity {

    private Button btn2,btn4,btn3,btn10,btn16;
    private TextView tv;
    String id="10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        String welcome = getIntent().getStringExtra("pos");
        Toast.makeText(this, "Welcome "+welcome, Toast.LENGTH_SHORT).show();

        btn2 = (Button)findViewById(R.id.button2);
        btn4 = (Button)findViewById(R.id.button4);
        btn3 = (Button) findViewById(R.id.button3);
        btn10 = (Button) findViewById(R.id.button10);
        btn16 = (Button) findViewById(R.id.button16);

        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(User.this,Newsfeed.class);
                startActivity(intent);

            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(User.this,Tips.class);
                intent.putExtra("name",getIntent().getStringExtra("pos"));
                intent.putExtra("role","0");
                startActivity(intent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            tv = (TextView)findViewById(R.id.textView5);

                Calendar Calender = null;
                Date dateAndTime = Calender.getInstance().getTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());
                String date = dateFormat.format(dateAndTime);
                String time = timeFormat.format(dateAndTime);
                tv.setText("Current Date - "+date+"\n\nCurrent Time - "+time);
               // Toast.makeText(User.this, "Attendance Submitted", Toast.LENGTH_LONG).show();
                String tmp = getIntent().getStringExtra("posmail");
               MyDatabaseHelper2 db = new MyDatabaseHelper2(User.this);
               // String name = getIntent().getStringExtra("pos");
               db.addBook(tmp,time.toString().trim(),"null",date.toString().trim());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar Calender2 = null;
                Date dateAndTime2 = Calender2.getInstance().getTime();
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                SimpleDateFormat timeFormat2 = new SimpleDateFormat("hh:mm:ss", Locale.getDefault());
                String date2 = dateFormat2.format(dateAndTime2);
                String time2 = timeFormat2.format(dateAndTime2);
                tv.setText("Current Date - "+date2+"\n\nCurrent Time - "+time2);
                String tmp = getIntent().getStringExtra("posmail");
                MyDatabaseHelper2 db = new MyDatabaseHelper2(User.this);

                // String name = getIntent().getStringExtra("pos");
                db.updateData(tmp,time2,date2);

               // Toast.makeText(User.this, "Check Out Submitted", Toast.LENGTH_LONG).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this,PieChartActivity.class);
                String tr = getIntent().getStringExtra("pos");

                intent.putExtra("pos",tr);

                startActivity(intent);
            }
        });
    }
}