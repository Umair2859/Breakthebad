package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class stars extends AppCompatActivity {
    RecyclerView recyclerView;
    private ArrayList<image> coursesArrayList;
    private Adapter adopt;
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    FirebaseAuth mAuth;
    String Userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stars);
        getSupportActionBar().hide();

        recyclerView=findViewById(R.id.review);
        coursesArrayList= new ArrayList<>();
        mAuth=FirebaseAuth.getInstance();
        Userid=mAuth.getCurrentUser().getUid();
        adopt = new Adapter(coursesArrayList, this);
        recyclerView.setAdapter(adopt);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Toast.makeText(this, "You have completed all of your tasks and got stars per task", Toast.LENGTH_SHORT).show();
        db.collection("Notebook").document(Userid).collection("goals").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        if (!queryDocumentSnapshots.isEmpty()) {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                coursesArrayList.add(new image(R.raw.stars, R.raw.stars,R.raw.stars,R.raw.stars,R.raw.stars));
                            }

                            adopt.notifyDataSetChanged();
                        } else {
                            Toast.makeText(stars.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Dashboard.class));
    }
}