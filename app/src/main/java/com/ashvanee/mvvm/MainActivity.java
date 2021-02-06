package com.ashvanee.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.ashvanee.mvvm.model.PostModel;
import com.ashvanee.mvvm.viewmodel.PostViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel = new PostViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel.getPostData().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                for(int i= 0; i < postModels.size(); i++){
                    Log.d("PostData",postModels.get(i).getBody());
                    Log.d("PostData",postModels.get(i).getTitle());

                }
            }
        });
    }
}