package com.example.coderspool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Questions_Activity extends AppCompatActivity {
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        back = findViewById(R.id.backk);
    }

    public void onClickBackk(View view){
        Intent intent = new Intent(getApplicationContext(),BooksCategory.class);
        startActivity(intent);
    }
}