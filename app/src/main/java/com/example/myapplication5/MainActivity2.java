package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication5.adapters.ArticleAdapter;
import com.example.myapplication5.models.Article;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        Toast.makeText(getApplicationContext(), intent.getStringExtra("name"), Toast.LENGTH_LONG).show();

        recyclerView = findViewById(R.id.recyclerview);
        articles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Article article = new Article("Title " + i, getResources().getString(R.string.content));
            articles.add(article);
        }

        ArticleAdapter articleAdapter = new ArticleAdapter(articles);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(articleAdapter);
    }


}