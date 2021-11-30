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

public class PythonBks extends AppCompatActivity {
    Toolbar javaToolBar;
    ImageView back;
    CardView algorithmsBook,crackingCodesWithPython,hackingCiphers,effectivePyt,
            mlLearning,handsOnPyt,seriousPyt,pythonrecipes,pythonGui,pythonprojects;
    DatabaseReference database,database2,database3,df4,df5,df6,df7,df8,df9,df10;
    String message,message2,message3,m4,m5,m6,m7,m8,m9,m10;
    BottomNavigationView btNv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python_bks);

        javaToolBar= findViewById(R.id.JavaToolBar);

        back = findViewById(R.id.back);

        algorithmsBook = findViewById(R.id.algorithmsBk);
        crackingCodesWithPython = findViewById(R.id.crackingCodesWithPython);
        hackingCiphers = findViewById(R.id.hackingCiphers);
        effectivePyt = findViewById(R.id.effectivePython);
        mlLearning = findViewById(R.id.machineLearningWithPyt);
        handsOnPyt = findViewById(R.id.handsOnPython);
        seriousPyt = findViewById(R.id.seriousPython);
        pythonGui = findViewById(R.id.pythonGui);
        pythonprojects = findViewById(R.id.pythonProjects);
        pythonrecipes = findViewById(R.id.pythonRecipes);


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

        database = FirebaseDatabase.getInstance().getReference("HandsOnPython");
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
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });





        database2 = FirebaseDatabase.getInstance().getReference("CrackingCodesWithPython");
        database2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message2 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });





       database3 = FirebaseDatabase.getInstance().getReference("HackingCyphers");
        database3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                message3 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });



        df4 = FirebaseDatabase.getInstance().getReference("EffectivePython");
        df4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                m4 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });





        df5 = FirebaseDatabase.getInstance().getReference("MlDesignWithPyt");
        df5.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                m5 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });



        df6 = FirebaseDatabase.getInstance().getReference("HandsOnPython");
        df6.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                m6 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });

        df7 = FirebaseDatabase.getInstance().getReference("SeriousPython");
        df7.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                m7 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });




        df8 = FirebaseDatabase.getInstance().getReference("PythonRecipes");
        df8.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                m8 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });





        df9 = FirebaseDatabase.getInstance().getReference("PythonGui");
        df9.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                m9 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });



        df10 = FirebaseDatabase.getInstance().getReference("PythonProjects");
        df10.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // getting a DataSnapshot for the location at the specified
                // relative path and getting in the link variable
                m10 = snapshot.getValue(String.class);
            }

            // this will called when any problem
            // occurs in getting data
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                // we are showing that error message in toast
                Toast.makeText(PythonBks.this, "Error Loading Pdf", Toast.LENGTH_SHORT).show();
            }
        });







    }

    public  void onClickBack(View view){
        Intent booksCategory = new Intent(getApplicationContext(),BooksCategory.class);
        startActivity(booksCategory);

    }

    public void onClickHandsOnPython(View view){

        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", message);
        startActivity(intent);
    }

    public void onClickCrackingCodes(View view){

        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", message2);
        startActivity(intent);
    }

   public void onCkickHackingCiphers(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", message3);
        startActivity(intent);
    }

    public void onClickEffectivePython(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m4);
        startActivity(intent);
    }

    public void onClickMachineLearningDesign(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m5);
        startActivity(intent);
    }

    public void onClickHandsOnPythonn(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m6);
        startActivity(intent);
    }

    public void onClickSeriousPython(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m7);
        startActivity(intent);
    }

    public void onClickPythonRecipes(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m8);
        startActivity(intent);
    }

    public void onClickPythonGui(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m9);
        startActivity(intent);
    }

    public void onClickPythonProjects(View view){
        Intent intent = new Intent(view.getContext(), JavaBooks.class);
        intent.putExtra("url", m10);
        startActivity(intent);
    }

}