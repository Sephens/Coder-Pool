package com.example.coderspool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BooksCategory extends AppCompatActivity {
    ImageView backImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_category);
        backImg = findViewById(R.id.back);
    }

    public void onClickBack(View back){
        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
        startActivity(intent);
    }

}