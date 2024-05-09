package com.example.flightbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class tickets extends AppCompatActivity {
    EditText pnrinp;
    TextView submit,details;
    DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference("booking");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);
        pnrinp=(EditText) findViewById(R.id.pnrinp);
        submit=(TextView) findViewById(R.id.submit);
        details=(TextView) findViewById(R.id.details);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pn=pnrinp.getText().toString();
                searchAndStoreData("pnr",pn);
            }
        });


    }
    public void searchAndStoreData (String columnName, String valueToSearch){
        Query query = mDatabase.orderByChild(columnName).equalTo(valueToSearch);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        // Get data from each snapshot
                        String classd = snapshot.child("class").getValue(String.class);
                        String dated = snapshot.child("date").getValue(String.class);
                        String fromd = snapshot.child("from").getValue(String.class);
                        String tod=snapshot.child("to").getValue(String.class);
                        String name = snapshot.child("name").getValue(String.class);
                        String passnumd = snapshot.child("passnum").getValue(String.class);
                        String serviced = snapshot.child("service").getValue(String.class);
                        // Add more columns as needed
                        details.setText("Source: "+fromd+"\nDestination: "+tod+"\nAirlines: "+serviced+"\nClass of Travel: "+classd+"\nPerson(s) Allowed: "+passnumd+"\nDeparture Date: "+dated);
                        // Now you have data from each column, you can do whatever you want with it

                        // Perform actions with the data here
                    }
                } else {
                    Toast.makeText(tickets.this,"Sorry", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Error occurred, handle it appropriately

            }
        });
    }
}

