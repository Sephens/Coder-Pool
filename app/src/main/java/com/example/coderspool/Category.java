package com.example.coderspool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Category extends AppCompatActivity {
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportActionBar().hide();
        backBtn=findViewById(R.id.back_arrow);
    }

    public void backArrow(View view){
        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
        startActivity(intent);
    }
}