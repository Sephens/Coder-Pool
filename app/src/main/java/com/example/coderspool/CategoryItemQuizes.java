package com.example.coderspool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class CategoryItemQuizes extends AppCompatActivity {

    public TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_item_quizes);

        txt = findViewById(R.id.categoryItemTextVieww);
        Typeface tp = ResourcesCompat.getFont(this,R.font.font2);
        txt.setTypeface(tp);
    }
}