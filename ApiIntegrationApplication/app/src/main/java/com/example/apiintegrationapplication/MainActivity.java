package com.example.apiintegrationapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCatFacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCatFacts = findViewById(R.id.rvCatFacts);

        CatFactApi apiInterface = RetrofitClient.getClient().create(CatFactApi.class);
        apiInterface.getCatFacts().enqueue(new Callback<List<CatFactResponse>>() {
            @Override
            public void onResponse(Call<List<CatFactResponse>> call, Response<List<CatFactResponse>> response) {
                Log.d("OK", "Is this running?");
                  for (int i = 0; i < response.body().size(); i++) {
                    Log.d("TAG", "The response is: " + response.body().toString());
               }

                rvCatFacts.setAdapter(new ItemAdapter(response.body()));
            }

            @Override
            public void onFailure(Call<List<CatFactResponse>> call, Throwable throwable) {
                // display toast
                Log.d("TAG",throwable.toString());
            }
        });
    }
}