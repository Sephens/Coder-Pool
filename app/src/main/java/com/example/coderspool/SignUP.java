package com.example.coderspool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class SignUP extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView logIn ;
   // private EditText txtemail,txtpassword,txtcofirmpass;
    TextInputLayout emaill, passs, confPass;
    private Button signup;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

        pbar =  findViewById(R.id.progressBars);
        signup = findViewById(R.id.sign_up);
        emaill = findViewById(R.id.sign_up_email);
        passs =findViewById(R.id.password);
        confPass = findViewById(R.id.confirm_password);

    }

    public void haveAccount(View view){
        TextView haveAccount = (TextView) findViewById(R.id.haveAccount);
        Intent loginPage = new Intent(SignUP.this,MainActivity.class);
        startActivity(loginPage);

    }

    public void onClickSignUp(View view){
        String email = emaill.getEditText().getText().toString().trim();
        String pass = passs.getEditText().getText().toString().trim();
        String conpass = confPass.getEditText().getText().toString().trim();

        if (email.isEmpty()){
            emaill.setError("Please enter email");
            emaill.requestFocus();
            return;
        }

       else if(pass.isEmpty()){
            passs.setError("Enter a password");
            passs.requestFocus();
            return;
        }

        else if (conpass.isEmpty()){
            confPass.setError("Confirm password");
            confPass.requestFocus();
            return;
        }
       else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emaill.setError("please provide valid email...");
            emaill.requestFocus();
            return;
        }

        else if (pass.length()<6){
            passs.setError("password too short");
            passs.requestFocus();
            return;
        }

        else if (conpass.length()<6){
            confPass.setError("password too short");
            confPass.requestFocus();
            return;
        }
        else if(!pass.equals(conpass)){
            confPass.setError("The password does not match");
            confPass.requestFocus();
            return;
        }
        pbar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(email,pass,conpass);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                                        Toast.makeText(SignUP.this, "Sign Up successful", Toast.LENGTH_SHORT).show();
                                        pbar.setVisibility(View.GONE);
                                        firebaseUser.sendEmailVerification();
                                        Toast.makeText(SignUP.this, "Please check your email to verify", Toast.LENGTH_LONG).show();
                                        pbar.setVisibility(View.GONE);
                                        Intent intent = new Intent(SignUP.this,MainActivity.class);
                                        startActivity(intent);

                                    }
                                    else {
                                        Toast.makeText(SignUP.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                        pbar.setBackgroundColor(Color.WHITE);
                                        pbar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }
                        else {
                            Toast.makeText(SignUP.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            pbar.setBackgroundColor(Color.WHITE);
                            pbar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}