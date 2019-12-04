package com.example.chance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class developers extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        String developers;
        String heading;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);

        TextView head = findViewById(R.id.devHead);
        heading = "ABOUT THE DEVELOPERS";
        head.setText(heading);

        TextView dev = findViewById(R.id.devText);
        developers = "The developers of this app, Dev and Abhishek. are currently freshmen at the University of illinois at Urbana Champaign." + '\n' + '\n' + "While Dev is majoring in Computer Science (Engineering), Abhishek is majoring in Chemical Engineering.";
        dev.setText(developers);
    }
}

