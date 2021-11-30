package com.example.coderspool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Questions_Activity extends AppCompatActivity {
    ImageView back;
    BottomNavigationView btNv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        back = findViewById(R.id.backk);

        btNv = findViewById(R.id.bottom_nav);
        btNv.setBackground(null);
        btNv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.dashboard_menu:
                        Intent dash = new Intent(getApplicationContext(),Dashboard.class);
                        startActivity(dash);
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.notes_menu:
                        Intent notes = new Intent(getApplicationContext(),NotePad.class);
                        startActivity(notes);
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    public void onClickBackk(View view){
        Intent intent = new Intent(getApplicationContext(),BooksCategory.class);
        startActivity(intent);
    }
}