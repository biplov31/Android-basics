package com.example.calculatorapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonViewHolder> {

    ArrayList<Button> buttons = new ArrayList<>();
    ButtonListener buttonListener;

    public ButtonAdapter(ArrayList<Button> buttons, ButtonListener buttonListener) {
        this.buttons = buttons;
        this.buttonListener = buttonListener;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_button, parent, false);
        return new ButtonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
        Button button = buttons.get(position);
        holder.setData(button);
    }

    // specify the total number of views
    @Override
    public int getItemCount() {
        return buttons.size();
    }

    class ButtonViewHolder extends RecyclerView.ViewHolder {
        MaterialButton button;

        public ButtonViewHolder(@NotNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.button);
        }

        public void setData(Button button) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonListener.buttonClicked(button);
                }
            });

        }
    }

}
