package com.example.coderspool;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

public class Scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores2);
        TextView scoreBoardTxt = findViewById(R.id.scoreBoardTextView);
        Toolbar scoreBoard = findViewById(R.id.levelsToolBar);
        setSupportActionBar(scoreBoard);


        Typeface tf = ResourcesCompat.getFont(this,R.font.font3);
        scoreBoardTxt.setTypeface(tf);
    }
}