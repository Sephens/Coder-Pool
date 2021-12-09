package com.example.coderspool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

public class LevelsActivityQuizzes extends AppCompatActivity {
    public TextView levels;
    private GridView levelsGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels_quizzes);

        Toolbar levelsToolBar = findViewById(R.id.levelsToolBar);
        setSupportActionBar(levelsToolBar);

        String title = getIntent().getStringExtra("CATEGORY");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        levelsGrid = findViewById(R.id.levelsGridView);

        levels = findViewById(R.id.levelsTxtView);
        Typeface tf = ResourcesCompat.getFont(this,R.font.font3);
        levels.setTypeface(tf);

        LevelsAdapterQuizzes levelsAdapter = new LevelsAdapterQuizzes(50);
        levelsGrid.setAdapter(levelsAdapter);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            LevelsActivityQuizzes.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}