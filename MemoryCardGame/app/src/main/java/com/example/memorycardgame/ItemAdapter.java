package com.example.memorycardgame;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    ArrayList<MemoryCardItem> items = new ArrayList<>();
    ItemListener itemListener;

    public ItemAdapter(ArrayList<MemoryCardItem> items, ItemListener itemListener) {
        this.items = items;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        MemoryCardItem item = items.get(position);
        holder.setData(item);
    }

    // specify the total number of views
    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView cardContent;
        Integer cardColor;

        public ItemViewHolder(@NotNull View itemView) {
            super(itemView);

            cardContent = itemView.findViewById(R.id.cardContent);
        }

        public void setData(MemoryCardItem cardItem) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.itemClicked(cardItem);
                }
            });

            cardContent.setText(cardItem.getCardContent());
        }
    }
}
