package com.adityanvs.scorekeeper2p;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView p1, p2;
    private int counter1, counter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1 = findViewById(R.id.scoreP1);
        p2 = findViewById(R.id.scoreP2);
        counter1 = 0;
        counter2 = 0;

        if (savedInstanceState != null){
            counter1 = savedInstanceState.getInt("s1");
            counter2 = savedInstanceState.getInt("s2");
            p1.setText(String.valueOf(counter1));
            p2.setText(String.valueOf(counter2));
        }
    }

    public void decrementScore1(View view) {
        counter1--;
        p1.setText(String.valueOf(counter1));
    }

    public void incrementScore1(View view) {
        counter1++;
        p1.setText(String.valueOf(counter1));
    }


    public void decrementScore2(View view) {
        counter2--;
        p2.setText(String.valueOf(counter2));
    }

    public void incrementScore2(View view) {
        counter2++;
        p2.setText(String.valueOf(counter2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("s1", counter1);
        outState.putInt("s2", counter2);
    }
}