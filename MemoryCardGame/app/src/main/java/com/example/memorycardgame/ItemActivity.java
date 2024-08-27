package com.example.memorycardgame;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class ItemActivity extends AppCompatActivity {

    MaterialCardView cardItem;
    ImageView unknownImage;
    TextView cardContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        cardItem = findViewById(R.id.cardItem);
        unknownImage = findViewById(R.id.unknownImage);
        cardContent = findViewById(R.id.cardContent);

        cardItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });

    }

    public void flipCard() {
        unknownImage.setVisibility(View.GONE);
        cardContent.setVisibility(View.VISIBLE);
        cardItem.setCardBackgroundColor(Color.parseColor("#111"));
        cardContent.setTextColor(Color.parseColor("#fff"));
    }
}