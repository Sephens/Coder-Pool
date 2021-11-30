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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CBks extends AppCompatActivity {
    Toolbar javaToolBar;
    ImageView back;
    CardView cTutorial,cNotesProf;
    DatabaseReference database,df2,df3,df4;
    String message,m2,m3,m4;
    BottomNavigationView btNv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cbks);
        javaToolBar= findViewById(R.id.JavaToolBar);
        back = findViewById(R.id.back);

        cTutorial= findViewById(R.id.cTutorial);
        cNotesProf = findViewById(R.id.cNotesProfessionals);

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


        database = FirebaseDatabase.getInstance().getReference("CProgrammingTutorial");
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(CBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        df2 = FirebaseDatabase.getInstance().getReference("CNotesProfessionals");
        df2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                m2 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(CBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public  void onClickBack(View view){
        Intent booksCategory = new Intent(getApplicationContext(),BooksCategory.class);
        startActivity(booksCategory);
    }
    public void onClickCTutorial(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", message);
        startActivity(intent);
    }
    public void onClickCNotesProfessionals(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m2);
        startActivity(intent);
    }
}