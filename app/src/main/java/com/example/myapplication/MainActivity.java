package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getSupportActionBar().hide();
        TextView tv = findViewById(R.id.tv);
        ImageView iv = findViewById(R.id.iv);
        iv.animate().alpha(1).setDuration(1000);
        tv.setAlpha(0);
        tv.setTranslationY(-200);
        tv.animate().translationYBy(50).alpha(1).setDuration(1200);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Overview.class);
                startActivity(intent);
                finish();
            }
        }, 1500);




    }
}