package com.example.flightbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import org.w3c.dom.Text;

public class operations extends AppCompatActivity {
    ImageView book,ticket,cancel;
    TextView dev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operations);
        book=(ImageView) findViewById(R.id.book);
        ticket=(ImageView) findViewById(R.id.tickets);
        cancel=(ImageView) findViewById(R.id.cancel);
        dev=(TextView) findViewById(R.id.dev);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(operations.this,book.class));
            }
        });
        ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(operations.this, tickets.class));
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(operations.this,cancel.class));
            }
        });
        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(operations.this,dev.class));
            }
        });
    }
}