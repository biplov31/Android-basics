package com.example.menunavfragment;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = findViewById(R.id.navMenu);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.actionHome) {
                    replaceFragment(new HomeFragment());
                } else if (item.getItemId() == R.id.actionProducts) {
                    replaceFragment(new ProductsFragment());
                } else if (item.getItemId() == R.id.actionAdd) {
                    replaceFragment(new AddFragment());
                } else if (item.getItemId() == R.id.actionExplore) {
                    replaceFragment(new ExploreFragment());
                } else if (item.getItemId() == R.id.actionSettings) {
                    replaceFragment(new SettingsFragment());
                }

                return true;
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}