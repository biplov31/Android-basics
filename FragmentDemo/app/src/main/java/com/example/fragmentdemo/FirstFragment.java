package com.example.fragmentdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate/specify the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

//    @Override
//    public void onViewCreated(@NonNull ) {
//        EditText emailField;
//
//        Toast.makeText(FirstFragment.this, email, Toast.LENGTH_SHORT).show();
//
//    }

}