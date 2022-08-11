package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class Dashboard extends AppCompatActivity {
    CardView one, two, three, four;
    TextView txt;
FirebaseAuth mAuth;
String UserId;
FirebaseFirestore mFirestore;

    public void health(View view) {
        switch (view.getId()) {
            case R.id.cardviewone:
                Intent intent = new Intent(Dashboard.this, Daily.class);
                startActivity(intent);
                break;
            case R.id.cardviewtwo:
                Intent intentt = new Intent(Dashboard.this, locations.class);
                startActivity(intentt);
                break;
            case R.id.cardviewthree:
                Intent intenttt = new Intent(Dashboard.this, Goals.class);
                startActivity(intenttt);
                break;
            case R.id.cardviewfour:
                Intent intentttt = new Intent(Dashboard.this, records.class);
                startActivity(intentttt);
                break;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        one = findViewById(R.id.cardviewone);
        two = findViewById(R.id.cardviewtwo);
        three = findViewById(R.id.cardviewthree);
        four = findViewById(R.id.cardviewfour);
        txt=findViewById(R.id.cu);
        mAuth = FirebaseAuth.getInstance();
         UserId = mAuth.getCurrentUser().getUid();
        mFirestore = FirebaseFirestore.getInstance();
        mFirestore.collection("Notebook").document(UserId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String user_name = documentSnapshot.getString("name");


                txt.setText(user_name);
            }
        });
    }
    }
