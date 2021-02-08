package com.example.retrofitlist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitlist.R;
import com.example.retrofitlist.controller.Controller;
import com.example.retrofitlist.databinding.ActivityMainBinding;
import com.example.retrofitlist.model.adapter.CustomAdapter;
import com.example.retrofitlist.model.api.GetDataService;
import com.example.retrofitlist.model.pojo.RetroPhoto;
import com.example.retrofitlist.model.api.RetrofitClientInstance;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements Controller.RetroPhotoListener {


    private CustomAdapter adapter;
    ActivityMainBinding activityMainBinding;
    RecyclerView recyclerView;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        controller=new Controller(MainActivity.this);
        controller.startFetching();
        setupRecyclerView();
       /* adapter = new CustomAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        activityMainBinding.customRecyclerView.setLayoutManager(layoutManager);
        activityMainBinding.customRecyclerView.setAdapter(adapter);*/


        /*GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

        service.getAllPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<List<RetroPhoto>>() {
                    @Override
                    public void onSuccess(List<RetroPhoto> photos) {
                        generateDataList(photos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this,"Error :"+e,Toast.LENGTH_LONG).show();
                    }
                });*/

        /*Call<List<RetroPhoto>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {

            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {

                if(response!=null && response.body()!=null){
                    int code=response.code();
                    switch (code){
                        case 200:
                            generateDataList(response.body());
                            break;
                        case 204:
                            Toast.makeText(MainActivity.this,"No Content",Toast.LENGTH_LONG).show();
                            break;
                        case  400:
                            Toast.makeText(MainActivity.this,"Bad Request",Toast.LENGTH_LONG).show();
                            break;
                        case 404:
                            Toast.makeText(MainActivity.this,"Not Found",Toast.LENGTH_LONG).show();
                            break;
                        default:
                            Toast.makeText(MainActivity.this,"Unknown Error Occurred",Toast.LENGTH_LONG).show();
                    }
                }


            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    private void setupRecyclerView() {
        recyclerView= activityMainBinding.customRecyclerView;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);

    }


    private void generateDataList(List<RetroPhoto> photoList) {
        if(photoList.size()<1){
            Toast.makeText(MainActivity.this,"No Data to Show",Toast.LENGTH_LONG).show();
        }
        else{
            adapter.setDataList(photoList);

        }

    }

    @Override
    public void onFetchComplete(List<RetroPhoto> list) {
        generateDataList(list);
    }

    @Override
    public void onError(Throwable t) {
        Toast.makeText(MainActivity.this,"ERROR: "+t,Toast.LENGTH_LONG).show();
    }
}