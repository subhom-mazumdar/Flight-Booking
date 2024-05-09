package com.example.flightbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class cancel extends AppCompatActivity {
    EditText pnrinp;
    TextView submit;
    DatabaseReference mDatabase= FirebaseDatabase.getInstance().getReference("booking");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        pnrinp=(EditText) findViewById(R.id.pnrinp);
        submit=(TextView) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Trigger the query to search for the data
                String pn=pnrinp.getText().toString();
                Query query = mDatabase.orderByChild("pnr").equalTo(pn);
                pnrinp.setText("");
                Toast.makeText(cancel.this,"We have successfully removed your booking (Remember its a cashless transaction)",Toast.LENGTH_LONG).show();
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            // Delete the data
                            snapshot.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle errors
                    }
                });
            }
        });
    }
}