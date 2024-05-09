package com.example.flightbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.google.firebase.database.*;

import android.content.Intent;

import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class login extends AppCompatActivity {
    public static String name="";
    public static String bid="";
    TextView login;
    EditText uid,passw;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbhelper help=new dbhelper(this);
        login=(TextView) findViewById(R.id.login);
        uid=(EditText) findViewById(R.id.uid);
        passw=(EditText) findViewById(R.id.passw);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u=uid.getText().toString();
                searchValueInDatabase("user","userid",u);
            }
        });

    }
    private void searchValueInDatabase(String tableName, String columnName, String searchValue) {
        Query query = mDatabase.child(tableName).orderByChild(columnName).equalTo(searchValue);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Check if dataSnapshot has any children
                if (dataSnapshot.exists()) {
                    // Value found
                    startActivity(new Intent(login.this, operations.class));
                } else {
                    // Value not found
                    startActivity(new Intent(login.this,register.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Error handling
//                Log.e(TAG, "Database Error: " + databaseError.getMessage());
            }
        });
    }
}