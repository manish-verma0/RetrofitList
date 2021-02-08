package com.example.retrofitlist.model.api;

import com.example.retrofitlist.model.pojo.RetroPhoto;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;


public interface GetDataService {

    @GET("cars_list.json")
    Single<List<RetroPhoto>> getAllPhotos();
}
