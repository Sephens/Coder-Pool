package com.example.coderspool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class AndroidBks extends AppCompatActivity {
    ImageView back;
    Toolbar androidToolBar;
    CardView androidReference,headFirstAndroid,androidThings,androidLearning;
    DatabaseReference database,df2,df3,df4;
    String message,m2,m3,m4;
    BottomNavigationView btNv;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_bks);
        back = findViewById(R.id.back);
        androidToolBar= findViewById(R.id.androidToolBar);
        androidReference=findViewById(R.id.androidReference);
        headFirstAndroid = findViewById(R.id.headFirstAndroid);
        androidThings = findViewById(R.id.androidThings);
        androidLearning=findViewById(R.id.androidLearning);
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

        database = FirebaseDatabase.getInstance().getReference("AndroidReference");
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                message = snapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // we are showing that error message in toast
                Toast.makeText(AndroidBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
        df2 = FirebaseDatabase.getInstance().getReference("HeadFirstAndroid");
        df2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                m2 = snapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AndroidBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
        df3 = FirebaseDatabase.getInstance().getReference("AndroidLearning");
        df3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                m3 = snapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AndroidBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
        df4 = FirebaseDatabase.getInstance().getReference("AndroidThings");
        df4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                m4 = snapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AndroidBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public  void onClickBack(View view){
        Intent booksCategory = new Intent(getApplicationContext(),BooksCategory.class);
        startActivity(booksCategory);
    }
    public void onClickAndroidReference(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", message);
        startActivity(intent);
    }
    public void onclickHeadFirstAndroid(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m2);
        startActivity(intent);
    }
    public void onClickAndroidLearning(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m3);
        startActivity(intent);
    }
    public void onClickAndroidThings(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m4);
        startActivity(intent);
    }
}