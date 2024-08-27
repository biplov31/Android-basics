package com.example.recyclerviewdemo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvProgrammingLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<LanguageDto> languages = new ArrayList<>();
        languages.add(new LanguageDto("Python", 1991));
        languages.add(new LanguageDto("Java", 1995));
        languages.add(new LanguageDto("Rust", 2006));
        languages.add(new LanguageDto("Go", 2009));
        languages.add(new LanguageDto("C#", 2000));
        languages.add(new LanguageDto("C", 1972));
        languages.add(new LanguageDto("C++", 1979));
        languages.add(new LanguageDto("JavaScript", 1995));

        languages.sort((o1, o2) -> o1.getFoundedDate().compareTo(o2.getFoundedDate()));

        rvProgrammingLanguages = findViewById(R.id.rvProgrammingLanguages);
        // sending data to the adapter via the constructor; RecyclerView doesn't know what the data is
        rvProgrammingLanguages.setAdapter(new ProgrammingLanguageAdapter(languages));
    }
}