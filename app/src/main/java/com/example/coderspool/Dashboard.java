package com.example.coderspool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    ImageView imgV,imgMenu,nendaNote;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    CardView booksCard,newsPaperCat;
    BottomNavigationView btNv;
    TextView txtbooks;
    private boolean running,wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        imgMenu = findViewById(R.id.menu_bar);
        navigationView = findViewById(R.id.nav_bar);
        drawerLayout = findViewById(R.id.drawerLayout);

        booksCard = findViewById(R.id.books_card);
        newsPaperCat = findViewById(R.id.newsPaperCat);

        txtbooks = findViewById(R.id.textbooks);

        btNv = findViewById(R.id.bottom_nav);
        btNv.setBackground(null);




        if (savedInstanceState!=null){
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }


         //btNv.setSelectedItemId(R.id.dashboard_menu);
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


    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    protected void onPause(){
        super.onPause();
        wasRunning=running;
        running=false;
    }

    protected void onResume(){
        super.onResume();
        if (wasRunning){
            running=true;
        }
    }


    public void thisImage(View view){
        Intent intent = new Intent(Dashboard.this,Category.class);
        startActivity(intent);
    }
    public void onClickMenuBar(View view){

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else drawerLayout.openDrawer(GravityCompat.START);
    }
    public void nendaNotePad(View vieq){
        Intent nenda = new Intent(Dashboard.this,NotePad.class);
        startActivity(nenda);
    }
    public void books(View view){
        Intent books = new Intent(Dashboard.this,BooksCategory.class);
        startActivity(books);
    }
    public void onClickQuestions(View v){
        Intent intent = new Intent(getApplicationContext(),Questions_Activity.class);
        startActivity(intent);
    }

    public void onClickNewsPaper(View view) {
        Intent intent = new Intent(Dashboard.this,NewsPaper.class);
        startActivity(intent);
    }
}