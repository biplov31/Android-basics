package com.example.rockpaperscissors;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RockPaperScissorsActivity extends AppCompatActivity {

    Button startBtn;
    ImageView replayBtn, homeBtn;
    LinearLayout playground;
    ImageView playerOne;
    ImageView playerTwo;
    LinearLayout homePage;
    RelativeLayout gamePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        startBtn = findViewById(R.id.startBtn);
        replayBtn = findViewById(R.id.replayBtn);
        homeBtn = findViewById(R.id.homeBtn);
        playground = findViewById(R.id.playground);
        playerOne = findViewById(R.id.playerOne);
        playerTwo = findViewById(R.id.playerTwo);
        homePage = findViewById(R.id.homePage);
        gamePage = findViewById(R.id.gamePage);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gamePage.setVisibility(View.GONE);
                homePage.setVisibility(View.VISIBLE);
            }
        });
    }

    private void startGame() {
        homePage.setVisibility(View.GONE);
        gamePage.setVisibility(View.VISIBLE);

        String[] options = {"rock", "paper", "scissors"};
    }
}