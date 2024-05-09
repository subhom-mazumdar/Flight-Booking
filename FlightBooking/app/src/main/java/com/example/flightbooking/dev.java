package com.example.flightbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class dev extends AppCompatActivity {
    ImageView linkedin,gmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);
        linkedin=(ImageView) findViewById(R.id.linkedin);
        gmail=(ImageView) findViewById(R.id.gmail);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String websiteUrl="https://www.linkedin.com/in/subhom-mazumdar-189a29253/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));

                // Verify that there's an app available to handle this intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    // Start the activity
                    startActivity(intent);
                }
            }
        });
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                if (clipboardManager != null) {
                    // Create a ClipData object to hold the text
                    ClipData clipData = ClipData.newPlainText("text", "subhom2003@gmail.com");

                    // Set the ClipData to the clipboard
                    clipboardManager.setPrimaryClip(clipData);

                    // Show a toast message indicating that the text has been copied
                    Toast.makeText(dev.this, "Mail Id copied to your clipboard", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}