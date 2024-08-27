package com.example.apiintegrationapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatFactApi {

    @GET("/facts")
    Call<List<CatFactResponse>> getCatFacts(); // CatFactResponse is already serialized

}
