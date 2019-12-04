package com.example.chance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String information;
        String heading;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView head = findViewById(R.id.infoHead);
        heading = "ABOUT THE GAME";
        head.setText(heading);

        TextView about = findViewById(R.id.infoText);
        information = "This game is called CHANCE." + '\n' + '\n' + "It is a simple game, where you roll a die and on the basis of your results, you win or lose." + '\n' + '\n' + "If you get 3 dice numbered greater than three, you WIN; else, you LOSE." + '\n' + '\n' + "We hope you have fun :)";
        about.setText(information);
    }
}
