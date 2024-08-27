package com.example.calculatorapplication;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class NumbersFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_numbers, container, false);
    }

    RecyclerView rvButtons;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(new Button(1, "1"));
        buttons.add(new Button(2, "2"));
        buttons.add(new Button(3, "3"));
        buttons.add(new Button(11, "+"));
        buttons.add(new Button(4, "4"));
        buttons.add(new Button(5, "5"));
        buttons.add(new Button(6, "6"));
        buttons.add(new Button(12, "-"));
        buttons.add(new Button(7, "7"));
        buttons.add(new Button(8, "8"));
        buttons.add(new Button(9, "9"));
        buttons.add(new Button(13, "*"));
        buttons.add(new Button(10, "0"));
        buttons.add(new Button(14, "/"));
        buttons.add(new Button(15, "="));


        rvButtons = view.findViewById(R.id.rvButtons);
        rvButtons.setAdapter(new ButtonAdapter(buttons, new ButtonListener() {
            @Override
            public void buttonClicked(Button button) {
                String firstNumber;
                String secondNumber;
                Action action;

                MaterialButton btn = view.findViewById(R.id.button);

            }
        }));

    }

}