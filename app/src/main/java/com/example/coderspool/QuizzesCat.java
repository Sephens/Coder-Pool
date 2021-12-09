package com.example.coderspool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class QuizzesCat extends AppCompatActivity {
    private GridView categoryGrid;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes_cat);

        Toolbar categoryToolBar = findViewById(R.id.toolBar);
        setSupportActionBar(categoryToolBar);
        getSupportActionBar().setTitle("Questions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoryGrid = findViewById(R.id.categoryGridView);
        List<QModel> categoryList = new ArrayList<>();
        categoryList.add(new QModel("Java",R.drawable.javabook));
        categoryList.add(new QModel("Python",R.drawable.pythonbook));
        categoryList.add(new QModel("Golang",R.drawable.gobook));
        categoryList.add(new QModel("Flutter",R.drawable.flutterbook));
        categoryList.add(new QModel("Android",R.drawable.androidbook));
        categoryList.add(new QModel("C#",R.drawable.csharp));
        categoryList.add(new QModel("Robotics",R.drawable.robotics));
        categoryList.add(new QModel("Javascript",R.drawable.js));
        categoryList.add(new QModel("C",R.drawable.cbook));
        CategoryGridAdapter categoryGridAdapter = new CategoryGridAdapter(categoryList);
        categoryGrid.setAdapter(categoryGridAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            QuizzesCat.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}