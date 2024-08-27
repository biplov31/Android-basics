package com.example.productrecyclerview;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProductDetailActivity extends AppCompatActivity {

    LinearLayout productDetailWrapper;
    TextView productTitle;
    TextView productDescription;
    TextView productPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");
        Integer color = getIntent().getIntExtra("color",0);
        Double price = getIntent().getDoubleExtra("price",0.0);

        productDetailWrapper = findViewById(R.id.productDetailWrapper);
        productTitle = findViewById(R.id.productDetailTitle);
        productTitle.setText(title);
        productDescription = findViewById(R.id.productDetailDescription);
        productDescription.setText(description);
        productPrice = findViewById(R.id.productDetailPrice);
        productPrice.setText(price + "");

    }
}