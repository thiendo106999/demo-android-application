package com.example.myapplication5.interfaces;

import com.example.myapplication5.models.Content;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArticleAPI {

    @GET("/api/content")
    Call<List<Content>> getContent();
}
