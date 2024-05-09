package com.example.flightbooking;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.content.*;
import android.view.View;
import android.widget.TextView;

public class home extends AppCompatActivity {
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        login=(TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this,login.class));
            }
        });
    }
}