package com.example.apiintegrationapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    List<CatFactResponse> items = new ArrayList<>();

    public ItemAdapter(List<CatFactResponse> itemDtos) {
        this.items = itemDtos;
    }

    // define the view to be repeated
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolder(view);
    }

    // set the data inside the view
    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        CatFactResponse item = items.get(position);
        holder.setData(item);
    }

    // specify the total number of views
    @Override
    public int getItemCount() {
        return items.size();
    }

    // we can create a separate class even though using an inner class is the convention
    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView content;
        TextView createdAt;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
            createdAt = itemView.findViewById(R.id.createdAt);
        }

        public void setData(CatFactResponse itemDto) {
            content.setText(itemDto.getContent());
            createdAt.setText(itemDto.getCreatedAt().toString());
        }

    }

}
