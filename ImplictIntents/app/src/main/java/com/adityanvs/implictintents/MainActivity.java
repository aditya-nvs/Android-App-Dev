package com.adityanvs.implictintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText urlText, locText;
    private Button urlBtn, locBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlText = findViewById(R.id.urlTextView);
        urlBtn = findViewById(R.id.urlBtnView);

        locText = findViewById(R.id.locTextView);
        locBtn = findViewById(R.id.locBtnView);

        urlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openURL();
            }
        });
        locBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaps();
            }
        });
    }

    private void openURL() {
        Intent i = new Intent();
        // Action type
        i.setAction(Intent.ACTION_VIEW);
        // Data
            // Step 1) Get Data
        String urlLink = urlText.getText().toString();
            // Step 2) Set Data
        i.setData(Uri.parse("https://" + urlLink));
            // Another Way
//        i.setData(Uri.parse("https://" + urlText.getText().toString()));
        // Start Activity
        startActivity(i);
    }

    private void openMaps() {
        Intent i = new Intent();
        // Action type
        i.setAction(Intent.ACTION_VIEW);
        // Data
            // Get Data
        String locName = locText.getText().toString();
            // Set Data
        i.setData(Uri.parse("geo:0,0?q=" + locName));
        // Start Activity
        startActivity(i);
    }
}

