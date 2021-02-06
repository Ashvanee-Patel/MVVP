package com.ashvanee.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ashvanee.mvvm.repository.PostApiRepo;
import com.ashvanee.mvvm.model.PostModel;

import java.util.List;

public class PostViewModel extends ViewModel {

        PostApiRepo apiRepo;
        MutableLiveData<List<PostModel>> getPosts;

        public PostViewModel (){
            apiRepo = new PostApiRepo();
        }

        public LiveData<List<PostModel>> getPostData(){
                if(getPosts == null){
                    getPosts = apiRepo.getPostData();
                }

                return getPosts;
        }

}
