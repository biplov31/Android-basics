package com.example.notebookapp.fragments;

import static com.example.notebookapp.database.NotebookDbHelper.DATABASE_NAME;
import static com.example.notebookapp.database.NotebookDbHelper.DATABASE_VERSION;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.notebookapp.adapters.NoteAdapter;
import com.example.notebookapp.database.NotebookDbHelper;
import com.example.notebookapp.models.Note;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        notebookDbHelper = new NotebookDbHelper(getContext(), DATABASE_NAME, null, DATABASE_VERSION);

        ArrayList<Note> notes = new ArrayList<>();
        notes.addAll(notebookDbHelper.getAllNotes());

        rvCategories = view.findViewById(R.id.rvCategories);
        rvNotes = view.findViewById(R.id.rvNotes);

        rvCategories.setAdapter(new CategoryAdapter());
        rvNotes.setAdapter(new NoteAdapter(notes));
    }

}
