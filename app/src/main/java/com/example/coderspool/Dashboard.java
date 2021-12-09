package com.example.coderspool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
    ImageView imgV,imgMenu,nendaNote;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    CardView booksCard,newsPaperCat;
    BottomNavigationView btNv;
    TextView txtbooks;
    private boolean rotate=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        imgMenu = findViewById(R.id.menu_bar);
        navigationView = findViewById(R.id.nav_bar);
        drawerLayout = findViewById(R.id.drawerLayout);

        FloatingActionButton fabAddNotes = findViewById(R.id.addNotes);
        final FloatingActionButton fabAllNotes = findViewById(R.id.allNotes);
        final FloatingActionButton fabTakeNotes = findViewById(R.id.takeNote);
        initShowOut(fabAllNotes);
        initShowOut(fabTakeNotes);

        booksCard = findViewById(R.id.books_card);
        newsPaperCat = findViewById(R.id.newsPaperCat);

        txtbooks = findViewById(R.id.textbooks);

        btNv = findViewById(R.id.bottom_nav);
        btNv.setBackground(null);


        fabAddNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotate = rotateFab(v, !rotate);
                if (rotate){
                    showIn(fabAllNotes);
                    showIn(fabTakeNotes);
                }else {
                    showOut(fabAllNotes);
                    showOut(fabTakeNotes);
                }
            }
        });



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

    public static void initShowOut(final View view){
        view.setVisibility(View.GONE);
        view.setTranslationY(view.getHeight());
        view.setAlpha(0f);
    }


    public static boolean rotateFab(final View view, boolean rotate){
        view.animate().setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .rotation(rotate ? 135f : 0f);
        return rotate;
    }



    public static void showIn(final View view){
        view.setVisibility(View.VISIBLE);
        view.setAlpha(0f);
        view.setTranslationY(view.getHeight());
        view.animate()
                .setDuration(200)
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .alpha(1f)
                .start();
    }

    public static void showOut(final View view){
        view.setVisibility(View.VISIBLE);
        view.setAlpha(1f);
        view.setTranslationY(0);
        view.animate()
                .setDuration(200)
                .translationY(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .alpha(0f)
                .start();
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
        Intent intent = new Intent(getApplicationContext(), QuizzesCat.class);
        startActivity(intent);
    }
    public void onClickNewsPaper(View view) {
        Intent intent = new Intent(Dashboard.this,NewsPaper.class);
        startActivity(intent);
    }



}