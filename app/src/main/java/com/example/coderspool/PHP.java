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

public class PHP extends AppCompatActivity {
    ImageView back;
    BottomNavigationView btNv;
    Toolbar androidToolBar;
    CardView mechatronics,controlSystems,computerVision;
    DatabaseReference database,df2,df3,df4;
    String message,m2,m3,m4;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php);
        back = findViewById(R.id.back);


        mechatronics = findViewById(R.id.mechatronicsRobotics);
        controlSystems = findViewById(R.id.controlSystems);
        computerVision = findViewById(R.id.computerVision);

        androidToolBar= findViewById(R.id.androidToolBar);

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



        database = FirebaseDatabase.getInstance().getReference("Mechatronics");
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                message = snapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // we are showing that error message in toast
                Toast.makeText(PHP.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        df2 = FirebaseDatabase.getInstance().getReference("Control Systems");
        df2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                m2 = snapshot.getValue(String.class);
            }
           @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // we are showing that error message in toast
                Toast.makeText(PHP.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        df3 = FirebaseDatabase.getInstance().getReference("Computer Vision");
        df3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                m3 = snapshot.getValue(String.class);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // we are showing that error message in toast
                Toast.makeText(PHP.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });
        
    }

    public void onClickBack(View view){
        Intent back = new Intent(getApplicationContext(),BooksCategory.class);
        startActivity(back);
        finish();
    }

    public void roboticsAndAutomation(View view) {
    }

    public void onClickComputerVision(View view) {
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m3);
        startActivity(intent);

    }

    public void onClickControlSystemsTwo(View view) {
    }

    public void onClickFullText(View view) {
    }

    public void onClickControlSystems(View view) {
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m2);
        startActivity(intent);
    }

    public void onClickMechatronicsRobotics(View view) {
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", message);
        startActivity(intent);
    }

    public void onClickRoboticsModelling(View view) {
    }
}