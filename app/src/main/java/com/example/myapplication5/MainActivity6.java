package com.example.myapplication5;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication5.interfaces.ArticleAPI;
import com.example.myapplication5.models.Content;
import com.example.myapplication5.models.ContentResponse;
import com.example.myapplication5.utils.APIClient;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity6 extends AppCompatActivity {
    private final String TAG = "MainActivity6";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        testGsonFunction();
        retrofitFunction();

    }

    private void testGsonFunction() {
        String dataUrl = "http://192.168.17.154:8080/api/content";
        String data = "{id=1, title='My first blog post', desc='My first blog post', createdAt=null, updatedAt=null, url=''}";
        Gson gson = new Gson();

        Content content = gson.fromJson(data, Content.class);
        Log.e(TAG, "testGsonFunction: " + content.toString());
        Log.e(TAG, "testGsonFunction: " + gson.toJson(content));
    }

    private void retrofitFunction() {
        ArticleAPI articleAPI = APIClient.getClient().create(ArticleAPI.class);

        Call<List<Content>> content = articleAPI.getContent();
        content.enqueue(new Callback<List<Content>>() {
            @Override
            public void onResponse(Call<List<Content>> call, Response<List<Content>> response) {
                List<Content> contents = response.body();
                Log.d("alo", "onResponse: " + contents.get(0).toString());
            }

            @Override
            public void onFailure(Call<List<Content>> call, Throwable t) {
                Log.d("alo", "onFailure: " + t.getMessage());

            }
        });
    }
}