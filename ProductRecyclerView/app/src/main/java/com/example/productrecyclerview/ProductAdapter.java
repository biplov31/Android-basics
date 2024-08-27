package com.example.productrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product> products;
    ProductListener productListener;

    public ProductAdapter(ArrayList<Product> products, ProductListener productListener) {
        this.products = products;
        this.productListener = productListener;
    }

    // define the view to be repeated
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    // set the data inside the view
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product language = products.get(position);
        holder.setData(language);
    }

    // specify the total number of views
    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productId;
        TextView productTitle;
        TextView productDescription;
        TextView productPrice;

        public ProductViewHolder(@NotNull View itemView) {
            super(itemView);

            productId = itemView.findViewById(R.id.productId);
            productTitle = itemView.findViewById(R.id.productTitle);
            productDescription = itemView.findViewById(R.id.productDescription);
            productPrice = itemView.findViewById(R.id.productPrice);
        }

        public void setData(Product product) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productListener.productClicked(product);
                }
            });

            productId.setText(product.getId() + "");
            productTitle.setText(product.getTitle()); // we cannot directly set an integer on a TextView because it starts looking for the value from the resources package
            productDescription.setText(product.getDescription());
            productPrice.setText(product.getPrice() + "");
        }
    }
}
