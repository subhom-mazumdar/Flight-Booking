package com.example.flightbooking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class book extends AppCompatActivity {
    EditText name,passnum,date,from,to;
    RadioButton airindia,indigo,spicejet,business,economy;
    Button submit;
    public static String pnr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        name=(EditText) findViewById(R.id.name);
        passnum=(EditText) findViewById(R.id.passnum);
        date=(EditText) findViewById(R.id.date);
        from=(EditText) findViewById(R.id.from);
        to=(EditText) findViewById(R.id.to);
        airindia=(RadioButton) findViewById(R.id.airindia);
        indigo=(RadioButton) findViewById(R.id.indigo);
        spicejet=(RadioButton) findViewById(R.id.spicejet);
        business=(RadioButton) findViewById(R.id.business);
        economy=(RadioButton) findViewById(R.id.economy);
        submit=(Button) findViewById(R.id.submit);
        passnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d=passnum.getText().toString();
                int sp=Integer.parseInt(d)*2000;
                submit.setText("Pay "+sp);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=name.getText().toString();
                String b=from.getText().toString();
                String c=to.getText().toString();
                String d=passnum.getText().toString();
                String e=date.getText().toString();
                String service="",classoft="";
                if(airindia.isChecked())
                    service="Air India";
                else if(indigo.isChecked())
                    service="Indigo";
                else
                    service="Spicejet";
                if(business.isChecked())
                    classoft="Business class";
                else
                    classoft="Economy class";
                Map<String,Object> map=new HashMap<>();
                map.put("name",a);
                map.put("from",b);
                map.put("to",c);
                map.put("passnum",d);
                map.put("date",e);
                map.put("service",service);
                map.put("class",classoft);
                Random rnm=new Random();
                pnr=Integer.toString(rnm.nextInt(300));
                map.put("pnr",pnr);
                FirebaseDatabase.getInstance().getReference().child("booking").push().setValue(map);
                showDialogBox();
            }
        });
    }
    private void showDialogBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("PNR Number"); // Set the title of the dialog box
        builder.setMessage(pnr); // Set the message of the dialog box

        // Set a positive button and its click listener
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Perform any action you want when the OK button is clicked
                dialog.dismiss(); // Dismiss the dialog box
            }
        });

        // Create and show the dialog box
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}