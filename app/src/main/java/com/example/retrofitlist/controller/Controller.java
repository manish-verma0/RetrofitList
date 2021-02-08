package com.example.retrofitlist.controller;

import android.widget.Toast;

import com.example.retrofitlist.model.api.GetDataService;
import com.example.retrofitlist.model.api.RetrofitClientInstance;
import com.example.retrofitlist.model.pojo.RetroPhoto;
import com.example.retrofitlist.view.MainActivity;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Controller {

    private final RetroPhotoListener listener;

    public Controller(RetroPhotoListener listener){
        this.listener=listener;
    }

    public void startFetching(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        service.getAllPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<RetroPhoto>>() {
                    @Override
                    public void onSuccess(List<RetroPhoto> photos) {

                            listener.onFetchComplete(photos);


                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onError(e);
                    }
                });
    }

    public interface RetroPhotoListener{

        void onFetchComplete(List<RetroPhoto> list);
        void onError(Throwable t);
    }
}
