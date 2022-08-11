package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    FirebaseAuth auth;
    EditText loginem;
    EditText loginpass;
    Button button;
    String em,  ps;

    public void enter(View view) {
        em = loginem.getText().toString();
        ps = loginpass.getText().toString();
        if (em.isEmpty()) {
            loginem.setError("Enter an email");
            loginem.requestFocus();
        }
        if (ps.isEmpty()) {
            loginpass.setError("Enter password");
            loginpass.requestFocus();
        } else {
            auth.signInWithEmailAndPassword(loginem.getText().toString().trim(), loginpass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean("key_name", true); // Storing boolean - true/false
                        editor.commit();
                        Intent intent = new Intent(Login.this, Dashboard.class);
                        startActivity(intent);


                    } else {
                        Toast.makeText(com.example.myapplication.Login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }

    }


    public void taketwo(View view){
    Intent intent= new Intent(Login.this, Signup.class);
    startActivity(intent);

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        auth=FirebaseAuth.getInstance();
        loginem=findViewById(R.id.loem);
        loginpass=findViewById(R.id.lopass);
        button = findViewById(R.id.sv);
        SharedPreferences sp=this.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        boolean b = sp.getBoolean("key_name", false);
        if(b==true){
            Intent intent=new Intent(this,Dashboard.class);
            startActivity(intent);
        }else{
//User is Not logged in, show login Form
        }
    }
}