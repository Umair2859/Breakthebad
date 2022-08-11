package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {
    EditText Email;
    EditText Password;
    Button Signup;
    FirebaseDatabase database;
    FirebaseAuth auth;
    EditText Name;

    boolean isPassVisible = false;
    EditText etAge;
    EditText etConfirmPassword;
    String strEtPassword, strEtConfirmPassword, strEtEmail, Age, fullname;


    public void showPassword(View view) {
        if (!isPassVisible) {
            etConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            isPassVisible = true;
        } else {
            etConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            isPassVisible = false;
        }
    }

    public void Register(View view) {

        strEtEmail = Email.getText().toString();
        strEtPassword = Password.getText().toString();
        fullname = Name.getText().toString();
        Age = etAge.getText().toString();
        if (fullname.isEmpty()) {
            Name.setError("Please enter your name");
            Name.requestFocus();
        }
        if (strEtEmail.isEmpty()) {
            Email.setError("Enter an email");
            Email.requestFocus();
        }

        if (strEtPassword.isEmpty()||strEtPassword.length()<6) {
            Password.setError("Enter password of atleast 6 characters");
            Password.requestFocus();

        }

        if (Age.isEmpty()) {
            etAge.setError("Enter age");
            etAge.requestFocus();


        }

        if (!Patterns.EMAIL_ADDRESS.matcher(strEtEmail).matches()) {
            Email.setError("Enter valid email");
            Email.requestFocus();
        }



    else {
            auth.getInstance().createUserWithEmailAndPassword(Email.getText().toString().trim(), Password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {


                                String userid = task.getResult().getUser().getUid();
                                Map<String,Object> data = new HashMap<>();

                                data.put("name",Name.getText().toString());
                                data.put("age",etAge.getText().toString());
                                data.put("email",Email.getText().toString());
                                data.put("pass",Password.getText().toString());
                                FirebaseFirestore.getInstance().collection("Notebook").document(userid).set(data);

Intent intent= new Intent(com.example.myapplication.Signup.this, Dashboard.class);
startActivity(intent);
                            } else {
                                Toast.makeText(com.example.myapplication.Signup.this, "Email is already taken", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
      Email=findViewById(R.id.loem);
      Password=findViewById(R.id.et_pass);
      Signup=findViewById(R.id.sign);
        auth= FirebaseAuth.getInstance();
database=FirebaseDatabase.getInstance();

etAge=findViewById(R.id.et_age);
Name= findViewById(R.id.name);

    }
}