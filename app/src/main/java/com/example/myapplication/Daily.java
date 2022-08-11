package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Daily extends AppCompatActivity {
FirebaseDatabase database;
FirebaseAuth auth;
EditText one,two,three,four,five,six,seven;
    String UserId;
    FirebaseFirestore mFirestore;
FirebaseAuth mAuth;
    int date=0;
    TextView days;
    String ab;
public  void save(View view){
    if (one.getText().toString().isEmpty()||two.getText().toString().isEmpty()||three.getText().toString().isEmpty()||four.getText().toString().isEmpty()||five.getText().toString().isEmpty()||six.getText().toString().isEmpty()||seven.getText().toString().isEmpty()){

        Toast.makeText(this, "Complete the above spaces first", Toast.LENGTH_SHORT).show();

    }
else {


            date=date+1;
    Map<String, Object> TASK = new HashMap<>();
    TASK.put("no", String.valueOf(date));
    TASK.put("task1", one.getText().toString());
    TASK.put("task2", two.getText().toString());
    TASK.put("task3", three.getText().toString());
    TASK.put("task4", four.getText().toString());
    TASK.put("task5", five.getText().toString());
    TASK.put("task6", six.getText().toString());
    TASK.put("task7", seven.getText().toString());

    mFirestore.collection("Notebook").document(UserId).collection("Daily").document().set(TASK).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(Daily.this, "Saved successfully", Toast.LENGTH_SHORT).show();
                }
            });


    Intent intent=new Intent(Daily.this, records.class);
    startActivity(intent);
    one.setText("");
    two.setText("");
    three.setText("");
    four.setText("");
    five.setText("");
    six.setText("");
    seven.setText("");}
}
public void views(){
    one=findViewById(R.id.tone);
    two=findViewById(R.id.ttwo);
    three=findViewById(R.id.tthree);
    four=findViewById(R.id.tfour);
    five =findViewById(R.id.tfive);
    six=findViewById(R.id.tsix);
    seven=findViewById(R.id.tseven);
    mAuth = FirebaseAuth.getInstance();
    UserId = mAuth.getCurrentUser().getUid();
    mFirestore = FirebaseFirestore.getInstance();
    days=findViewById(R.id.day);



}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_tasks);
        getSupportActionBar().hide();
database=FirebaseDatabase.getInstance();
auth= FirebaseAuth.getInstance();
views();
        SharedPreferences getsharedPrefernces= getSharedPreferences("MySharedPref", MODE_PRIVATE);
        ab= getsharedPrefernces.getString("goal1", " ");
        days.setText(ab);
}
}