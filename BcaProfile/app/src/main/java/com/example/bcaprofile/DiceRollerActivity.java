package com.example.bcaprofile;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DiceRollerActivity extends AppCompatActivity {

    RelativeLayout diceBackground;
    Button button;
    ImageView diceImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dice_roller);

        diceBackground = findViewById(R.id.diceBackground);
        diceImg = findViewById(R.id.diceImg);
        diceImg.setVisibility(View.GONE);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollTheDice();
            }
        });
    }

    void rollTheDice() {
        Log.d("MYLOG", "Rolling the dice.");

        Random random = new Random();
        int randomNum = random.nextInt(6) + 1;

        switch(randomNum) {
            case 1:
                diceImg.setImageResource(R.drawable.dice_1);
                break;
            case 2:
                diceImg.setImageResource(R.drawable.dice_2);
                break;
            case 3:
                diceImg.setImageResource(R.drawable.dice_3);
                break;
            case 4:
                diceImg.setImageResource(R.drawable.dice_4);
                break;
            case 5:
                diceImg.setImageResource(R.drawable.dice_5);
                break;
            case 6:
                diceImg.setImageResource(R.drawable.dice_6);
                break;
        }

        int color = Color.argb(255, random.nextInt(255), random.nextInt(255),random.nextInt(255));

        diceBackground.setBackgroundColor(color);

        diceImg.setVisibility(View.VISIBLE);
    }

}