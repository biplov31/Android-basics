package com.example.productrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "The North Face jacket", "Best jacket at this price point.", 1234, 5000.0));
        products.add(new Product(2, "Peak shoes", "Most comfortable shoes for daily usage.", 5678, 4500.0));
        products.add(new Product(3, "MT helmet", "Safest helmet with ECE 22.06 certification.", 6789, 5000.0));


        rvProducts = findViewById(R.id.rvProducts);
        rvProducts.setAdapter(new ProductAdapter(products, new ProductListener() {
            @Override
            public void productClicked(Product product) {
                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                intent.putExtra("id", product.getId());
                intent.putExtra("title", product.getTitle());
                intent.putExtra("description", product.getDescription());
                intent.putExtra("color", product.getColor());
                intent.putExtra("price", product.getPrice());
                startActivity(intent);
                // Toast.makeText(MainActivity.this, product.getTitle(), Toast.LENGTH_SHORT).show();
            }
        }));

    }
}