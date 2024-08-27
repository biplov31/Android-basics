package com.example.memorycardgame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvCardItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MemoryCardItem> cardItems = new ArrayList<>();
        cardItems.add(new MemoryCardItem("1", 1));
        cardItems.add(new MemoryCardItem("A", 2));
        cardItems.add(new MemoryCardItem("1", 3));
        cardItems.add(new MemoryCardItem("9", 4));
        cardItems.add(new MemoryCardItem("Z", 5));
        cardItems.add(new MemoryCardItem("A", 6));

        rvCardItems = findViewById(R.id.rvCardItems);
        rvCardItems.setAdapter(new ItemAdapter(cardItems, new ItemListener() {
            @Override
            public void itemClicked(MemoryCardItem cardItem) {
                int firstCardId;
                int secondCardId;

                MaterialCardView cardItemContainer = findViewById(R.id.cardItem);
                ImageView unknownImage = findViewById(R.id.unknownImage);
                TextView cardContent = findViewById(R.id.cardContent);

                unknownImage.setVisibility(View.GONE);
                cardContent.setVisibility(View.VISIBLE);
                cardItemContainer.setCardBackgroundColor(Color.parseColor("#111111"));
                cardContent.setTextColor(Color.parseColor("#ffffff"));

                firstCardId = cardItem.getId();
            }
        }));

    }
}