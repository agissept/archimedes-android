package com.app.myapplication.rest;


import com.app.myapplication.model.PostResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {
    @GET("/api/post")
    Call<PostResponse> getPosts();
}
