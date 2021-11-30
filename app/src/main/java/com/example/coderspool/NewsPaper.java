package com.example.coderspool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Model.Articles;
import Model.Headlines;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsPaper extends AppCompatActivity {
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    final String API_KEY ="1238bd71ad834bd192e94d5cd8ffe727";
    List<Articles> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_paper);

        articles = new ArrayList<>();
        recyclerView = findViewById(R.id.newsRecyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String country = getCountry();
        retrieveJSon(country,API_KEY);
    }
    public  void retrieveJSon(String country,String apiKey){
        Call<Headlines> call = ApiClient.getInstance().getApi().getHeadlines(country,apiKey);

        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles() !=null){
                    articles.clear();
                    articles = response.body().getArticles();
                    newsAdapter = new NewsAdapter(NewsPaper.this,articles);
                    recyclerView.setAdapter(newsAdapter);
                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {

                Toast.makeText(NewsPaper.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public String getCountry(){
        Locale locale = Locale.getDefault();
        String country = locale.getCountry();
        return country.toLowerCase();
    }
}