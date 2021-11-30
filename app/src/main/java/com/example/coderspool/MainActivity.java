package com.example.coderspool;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.NetworkInterface;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextInputLayout loginEmail,loginpass;
    //private TextInputLayout email, pass, confPass;
    private Button loginBtn;
    private ProgressBar logInProBar;
    private DatabaseReference userRefLogin;
    private FirebaseUser curUser;
    CheckBox remember_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        loginEmail =  findViewById(R.id.emailLogIn);
        loginpass =  findViewById(R.id.passwordLogIn);
        loginBtn =  findViewById(R.id.btn_login);
        logInProBar = findViewById(R.id.progressBarLogin);

        remember_me=findViewById(R.id.rememberMe);
    }
    public void dontHaveAccount(View view){
        TextView dontHaveAccount = (TextView) findViewById(R.id.dont_have_account);
        Intent signUpPage = new Intent(MainActivity.this,SignUP.class);
        startActivity(signUpPage);
    }
    protected void onStart(){
        super.onStart();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser==null){
            Intent intent = new Intent(MainActivity.this,SignUP.class);
            startActivity(intent);
        }
    }
    public void onClickLogIn(View view){
        String logEmail = loginEmail.getEditText().getText().toString().trim();
        String logPass = loginpass.getEditText().getText().toString().trim();
        if(!isConnected(this)){
            showCustomDialog();
        }
        if (logEmail.isEmpty()){
            loginEmail.setError("Please enter your email");
            loginEmail.requestFocus();
            return;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(logEmail).matches()){
            loginEmail.setError("Please provide a valid email");
            loginEmail.requestFocus();
            return;
        }
        else if (logPass.isEmpty()){
            loginpass.setError("Please enter your password");
            loginpass.requestFocus();
            return;
        }
        else if (logPass.length()<6){
            loginpass.setError("Too short password!!");
            loginpass.requestFocus();
            return;
        }
        else {
            logInProBar.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(logEmail,logPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                        if (firebaseUser.isEmailVerified()){
                            Handler dash = new Handler();
                            dash.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(MainActivity.this,Dashboard.class);
                                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                                    logInProBar.setVisibility(View.GONE);
                                    startActivity(intent);
                                }
                            },2000);
                        }else {
                            Toast.makeText(MainActivity.this, "Please verify your email in order to continue", Toast.LENGTH_LONG).show();
                            logInProBar.setVisibility(View.GONE);
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Email or password error. Please check", Toast.LENGTH_LONG).show();
                        logInProBar.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
    private boolean isConnected(MainActivity mainActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager)mainActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wificon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobilecon = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (wificon!=null && wificon.isConnected() || (mobilecon!=null && mobilecon.isConnected())){
            return true;
        }else
            return false;
    }
    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Please check your internet connection")
        .setCancelable(false)
        .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
       AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}