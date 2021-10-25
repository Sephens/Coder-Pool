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
    private EditText txtemail,txtpassword,txtcofirmpass;
    private Button signup;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

        pbar = (ProgressBar) findViewById(R.id.progressBars);
        signup = (Button) findViewById(R.id.sign_up);
        txtemail = (EditText) findViewById(R.id.useremails);
        txtpassword =(EditText) findViewById(R.id.passwords);
        txtcofirmpass = (EditText) findViewById(R.id.confirm_passwords);


    }

    public void haveAccount(View view){
        TextView haveAccount = (TextView) findViewById(R.id.haveAccount);
        Intent loginPage = new Intent(SignUP.this,MainActivity.class);
        startActivity(loginPage);

    }

    public void onClickSignUp(View view){
        String email = txtemail.getText().toString().trim();
        String pass = txtpassword.getText().toString().trim();
        String conpass = txtcofirmpass.getText().toString().trim();

        if (email.isEmpty()){
            txtemail.setError("Provide an email");
            txtemail.requestFocus();
            return;
        }

       else if(pass.isEmpty()){
            txtpassword.setError("Enter a password");
            txtpassword.requestFocus();
            return;
        }

        else if (conpass.isEmpty()){
            txtcofirmpass.setError("Confirm password");
            txtcofirmpass.requestFocus();
            return;
        }
       else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            txtemail.setError("please provide valid email...");
            txtemail.requestFocus();
            return;
        }

        else if (pass.length()<6){
            txtpassword.setError("password too short");
            txtpassword.requestFocus();
            return;
        }

        else if (conpass.length()<6){
            txtcofirmpass.setError("password too short");
            txtcofirmpass.requestFocus();
            return;
        }
        else if(!pass.equals(conpass)){
            txtcofirmpass.setError("The password does not match");
            txtcofirmpass.requestFocus();
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
                                        Toast.makeText(SignUP.this, "User has been registered successfully", Toast.LENGTH_SHORT).show();
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