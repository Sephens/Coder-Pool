package com.example.coderspool;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
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

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextInputLayout loginEmail,loginpass;
    //private TextInputLayout email, pass, confPass;
    private Button loginBtn;
    private ProgressBar logInProBar;
    private DatabaseReference userRefLogin;
    private FirebaseUser curUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        loginEmail =  findViewById(R.id.emailLogIn);
        loginpass =  findViewById(R.id.passwordLogIn);
        loginBtn =  findViewById(R.id.btn_login);
        logInProBar = findViewById(R.id.progressBarLogin);
        
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
                            Intent intent = new Intent(MainActivity.this,UserProfile.class);
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                            logInProBar.setVisibility(View.GONE);
                            startActivity(intent);
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

}