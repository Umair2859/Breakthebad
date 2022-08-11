package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class locations extends AppCompatActivity {
    private LinearLayout llGym;
    private LinearLayout llPark;
    private LinearLayout llSports;




    private void intViews( ) {
        llGym = findViewById(R.id.ll_gym);
        llPark = findViewById(R.id.ll_park);
        llSports = findViewById(R.id.ll_sports);
    }

    public void onClick(View v) {
        String queryName = null;

        if (v == llGym) {
            queryName = "gyms";
        }

        if (v == llPark) {
            queryName = "parks";
        }

        if (v == llSports) {
            queryName = "sports";
        }

        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + queryName);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_activities);
        intViews();
        getSupportActionBar().hide();
    }
}