package com.adityanvs.tallycounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView sc;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connecting score view i.e. result as id on activity_main.xml to MainActivity.java through sc object
        sc = findViewById(R.id.result);

        if (savedInstanceState != null){
            count = savedInstanceState.getInt("TALLY");
            sc.setText(String.valueOf(count));
        }
    }

    public void decrementScore(View view) {
        count--;
        sc.setText(String.valueOf(count));
        Toast.makeText(this, "Decremented", Toast.LENGTH_SHORT).show();
    }

    public void incrementScore(View view) {
        count++;
        sc.setText(""+count);
        Toast.makeText(this, "Incremented", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("TALLY", count);
    }
}