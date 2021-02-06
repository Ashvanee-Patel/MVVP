package com.ashvanee.mvvm.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.ashvanee.mvvm.model.PostModel;
import com.ashvanee.mvvm.network.ApiInterface;
import com.ashvanee.mvvm.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostApiRepo {

    public MutableLiveData<List<PostModel>> getPostData(){

        final MutableLiveData<List<PostModel>> posModel = new MutableLiveData<>();
        ApiInterface apiInterface = RetrofitClient.getInstance().create(ApiInterface.class);

        apiInterface.getPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                posModel.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                Log.d("FAILURE","Error "+t.toString());
            }
        });

        return posModel;

    }
}
