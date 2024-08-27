package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// after extending, we can use predefined methods in our own adapter class
public class ProgrammingLanguageAdapter extends RecyclerView.Adapter<ProgrammingLanguageAdapter.ProgrammingViewHolder> {

    List<LanguageDto> languages = new ArrayList<>();

    public ProgrammingLanguageAdapter(List<LanguageDto> languages) {
        this.languages = languages;
    }

    // define the view to be repeated
    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_programming_language, parent, false);
        return new ProgrammingViewHolder(view);
    }

    // set the data inside the view
    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {
        LanguageDto language = languages.get(position);
        holder.setData(language);
    }

    // specify the total number of views
    @Override
    public int getItemCount() {
        return languages.size();
    }

    // we can create a separate class even though using an inner class is the convention
    class ProgrammingViewHolder extends RecyclerView.ViewHolder {

        TextView tvProgrammingLanguage;
        TextView foundedDate;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProgrammingLanguage = itemView.findViewById(R.id.tvProgrammingLanguage);
            foundedDate = itemView.findViewById(R.id.foundedDate);
        }

        public void setData(LanguageDto language) {
            tvProgrammingLanguage.setText(language.getName());
            foundedDate.setText("Since: " + language.getFoundedDate()); // we cannot directly set an integer on a TextView because it starts looking for the value from the resources package
        }

    }

}
