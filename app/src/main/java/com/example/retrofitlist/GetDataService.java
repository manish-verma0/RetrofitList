package com.example.retrofitlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GetDataService {

    @GET("cars_list.json")
    Call<List<RetroPhoto>> getAllPhotos();
}
