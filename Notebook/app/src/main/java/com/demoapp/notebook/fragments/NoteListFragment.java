package com.demoapp.notebook.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demoapp.notebook.R;
import com.demoapp.notebook.adapters.NoteAdapter;


public class NoteListFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_note_list, container, false);

        RecyclerView noteRecyclerView = view.findViewById(R.id.noteRecyclerView);
        noteRecyclerView.setAdapter(new NoteAdapter());

        return view;
    }
}