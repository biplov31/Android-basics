package com.example.notebookapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notebookapp.R;
import com.example.notebookapp.adapters.NoteAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class NoteListFragment extends Fragment {

    FloatingActionButton addBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_note_list, container, false);

        RecyclerView noteRecyclerView = view.findViewById(R.id.noteRecyclerView);
        noteRecyclerView.setAdapter(new NoteAdapter());

        return view;
    }
}