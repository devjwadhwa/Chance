package com.example.chance;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
//import android.media.Ringtone;
//import android.media.RingtoneManager;
//import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int wctr = 0;
    private int lctr = 0;
    private int i = 0;
    private ImageView imageViewDice;
    private Random rng = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewDice = findViewById(R.id.image_view_dice);
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceRoll();
            }
        });

        Button button = findViewById(R.id.info);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unused) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, InfoActivity.class));
            }
        });

        Button tubbon = findViewById(R.id.dev);
        tubbon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unused) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, developers.class));
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void diceRoll() {
        MediaPlayer roll = MediaPlayer.create(MainActivity.this, R.raw.diceroll);
        roll.start();
        int num = rng.nextInt(6) + 1;
        switch (num) {
            case 1:
                imageViewDice.setImageResource(R.drawable.pic1);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.pic2);
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.pic3);
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.pic4);
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.pic5);
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.pic6);
                break;
        }
        if (num > 3) {
            wctr++;
            TextView t = findViewById(R.id.textView);
            t.setText("> 3 : Won " + wctr + " times");
        } else {
            lctr++;
            TextView t = findViewById(R.id.textView2);
            t.setText("<= 3 : Lost " + lctr + " times");
        }

        if (wctr == 3) {
            MediaPlayer song = MediaPlayer.create(MainActivity.this, R.raw.win);
            song.start();
            Toast.makeText(this, "You WIN!" + '\n' + "Pop the champagne" + '\n' + "Congratulations :)", Toast.LENGTH_LONG).show();
            finish();

        } else if (lctr == 3) {
            MediaPlayer song = MediaPlayer.create(MainActivity.this ,R.raw.lose);
            song.start();
            Toast.makeText(this, "You LOSE!" + '\n' + "Kill Yourself" + '\n'+ "Nah, I'm kidding :P", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}