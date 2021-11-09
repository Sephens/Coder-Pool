package com.example.coderspool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    RecyclerView recycler1,recycler2,recycler3,recycler4;
    RecyclerView.Adapter adapterr,adapt2,adapt3,adapt4;
    ImageView imgV,imgMenu,nendaNote;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    CardView booksCard;
    TextView txtbooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        imgMenu = findViewById(R.id.menu_bar);
        navigationView = findViewById(R.id.nav_bar);
        drawerLayout = findViewById(R.id.drawerLayout);

        booksCard = findViewById(R.id.books_card);

        txtbooks = findViewById(R.id.textbooks);
        //getSupportActionBar().hide();

      /*  recycler1 = findViewById(R.id.recycler1);
        recycler2 = findViewById(R.id.recycler2);
        recycler3 = findViewById(R.id.recycler3);
        recycler4 = findViewById(R.id.recycler4);

        imgV = findViewById(R.id.imago);
        nendaNote= findViewById(R.id.enda_notepad);



        recycler1();
        recycler2();
        recycler3();
        recycler4();

       */
    }

    private void recycler1() {
        recycler1.setHasFixedSize(true);
        recycler1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<SlideAdapterHelper> ssl = new ArrayList<>();
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));

        adapterr = new adapter(ssl);
        recycler1.setAdapter(adapterr);
    }


    private void recycler2() {
        recycler2.setHasFixedSize(true);
        recycler2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<SlideAdapterHelper> ssl = new ArrayList<>();
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));

        adapt2 = new adapter(ssl);
        recycler2.setAdapter(adapt2);
    }

    private void recycler3() {
        recycler3.setHasFixedSize(true);
        recycler3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<SlideAdapterHelper> ssl = new ArrayList<>();
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));

        adapt3 = new adapter(ssl);
        recycler3.setAdapter(adapt3);
    }

    private void recycler4() {
        recycler4.setHasFixedSize(true);
        recycler4.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<SlideAdapterHelper> ssl = new ArrayList<>();
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.c,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.react,"image2","So nice to program"));
        ssl.add(new SlideAdapterHelper(R.drawable.java,"image3","So nice to program"));

        adapt4 = new adapter(ssl);
        recycler4.setAdapter(adapt4);
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
}