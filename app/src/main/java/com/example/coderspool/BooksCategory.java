package com.example.coderspool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BooksCategory extends AppCompatActivity {
    ImageView backImg;
    CardView javaCard,pythonCard,androidCard,phpCat,flutterCat,goCat,cSharpCat,cPlusCat,javaScriptCat,Ccat;
    BottomNavigationView btNv;
    private boolean running,wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_category);
        backImg = findViewById(R.id.back);
        javaCard= findViewById(R.id.javaCard);
        pythonCard = findViewById(R.id.pythonCard);
        androidCard = findViewById(R.id.androidCategory);
        phpCat=findViewById(R.id.PHPCat);
        flutterCat=findViewById(R.id.FlutterCat);
        goCat = findViewById(R.id.GoCat);
        cSharpCat=findViewById(R.id.CsharpCat);
        cPlusCat = findViewById(R.id.CPlusCat);
        javaScriptCat = findViewById(R.id.JavaScriptCat);
        Ccat = findViewById(R.id.Ccategory);

        btNv = findViewById(R.id.bottom_nav);

        if (savedInstanceState!=null){
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        //btNv.setSelectedItemId(R.id.dashboard_menu);
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
    public void onClickBack(View back){
        Intent intent = new Intent(getApplicationContext(),BooksCategory.class);
        startActivity(intent);
        finish();
    }
    public void onclickJava(View view){
        Intent javabooks = new Intent(getApplicationContext(),JavaBks.class);
        startActivity(javabooks);
        finish();
    }
    public void onclickPython(View view){
        Intent javabooks = new Intent(getApplicationContext(),PythonBks.class);
        startActivity(javabooks);
        finish();
    }
    public void onClickAndroidCategory(View view){
        Intent androidbooks = new Intent(getApplicationContext(),AndroidBks.class);
        startActivity(androidbooks);
        finish();
    }
    public void onClickPHP(View view){
        Intent phpbooks = new Intent(getApplicationContext(),PHP.class);
        startActivity(phpbooks);
        finish();
    }
    public void onClickFlutter(View view){
        Intent flutterBks = new Intent(getApplicationContext(),FlutterBks.class);
        startActivity(flutterBks);
        finish();
    }
    public void onClickGolang(View view){
        Intent golangBks = new Intent(getApplicationContext(),GolangBks.class);
        startActivity(golangBks);
        finish();
    }
    public void onClickCSharp(View view){
        Intent cSharpBks = new Intent(getApplicationContext(),CSharpBks.class);
        startActivity(cSharpBks);
        finish();
    }
    public void onClickCPlus(View view){
        Intent cPlusBks = new Intent(getApplicationContext(),CPlusBks.class);
        startActivity(cPlusBks);
        finish();
    }
    public void onClickJavaScript(View view){
        Intent jsBks = new Intent(getApplicationContext(),JavaScriptBks.class);
        startActivity(jsBks);
        finish();
    }
    public void onClickC(View view){
        Intent CBks = new Intent(getApplicationContext(),CBks.class);
        startActivity(CBks);
        finish();
    }
}