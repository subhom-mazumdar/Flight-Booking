package com.example.flightbooking;
import androidx.appcompat.app.AppCompatActivity;
import android.content.*;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

import java.util.*;

public class register extends AppCompatActivity {
    TextView register;
    EditText username,name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbhelper help=new dbhelper(this);
//        SQLiteDatabase db=help.getReadableDatabase();
        register=(TextView) findViewById(R.id.register);
        username=(EditText) findViewById(R.id.username);
        name=(EditText) findViewById(R.id.name);
        pass=(EditText) findViewById(R.id.pass);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid=username.getText().toString();
                String nm=name.getText().toString();
                String passw=pass.getText().toString();
                Map<String,Object> map=new HashMap<>();
                map.put("userid",uid);
                map.put("name",nm);
                map.put("password",passw);
                FirebaseDatabase.getInstance().getReference().child("user").push().setValue(map);
                startActivity(new Intent(register.this,login.class));
            }
        });
    }
}