package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Map;

public class Goals extends AppCompatActivity {
 EditText o,t,th,fr,fv;
 TextView a,b,c,d,e;
 CheckBox abc,cde,efg,hij,klm;
 LinearLayout layout;
 FirebaseFirestore mstore=FirebaseFirestore.getInstance();
 FirebaseAuth mauth= FirebaseAuth.getInstance();
 String Userid=mauth.getCurrentUser().getUid();

public void reward(View view){
    if(abc.isChecked()&&cde.isChecked()&&efg.isChecked()&&hij.isChecked()&&klm.isChecked()){
        Map<String, Object> TASK2 = new HashMap<>();
        TASK2.put("g1",a.getText().toString());
        TASK2.put("g2", b.getText().toString());
        TASK2.put("g3", c.getText().toString());
        TASK2.put("g4", d.getText().toString());
        TASK2.put("g5", e.getText().toString());

mstore.collection("Notebook").document(Userid).collection("goals").document().set(TASK2).addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {
        Toast.makeText(Goals.this, "Saved successfully", Toast.LENGTH_SHORT).show();

    }
});
        SharedPreferences settings = getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        settings.edit().clear().commit();

        Intent intent=new Intent(Goals.this, stars.class);
        startActivity(intent);
    }
else{

        Toast.makeText(Goals.this, "Please complete all the goals to get the reward", Toast.LENGTH_SHORT).show();
    }
}
    public void goal(View view){

            if (o.getText().toString().isEmpty()||t.getText().toString().isEmpty()||th.getText().toString().isEmpty()||fr.getText().toString().isEmpty()||fv.getText().toString().isEmpty()){

                Toast.makeText(this, "Complete the above spaces first", Toast.LENGTH_SHORT).show();

            }
            else {
                String texto = o.getText().toString();
                String textt = t.getText().toString();
                String textth = th.getText().toString();
                String textf = fr.getText().toString();
                String textfv = fv.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("goal1", texto);
                myEdit.putString("goal2", textt);
                myEdit.putString("goal3", textth);
                myEdit.putString("goal4", textf);
                myEdit.putString("goal5", textfv);
                myEdit.apply();
                a.setText(texto);
                b.setText(textt);
                c.setText(textth);
                d.setText(textf);
                e.setText(textfv);
                o.setText("");
                t.setText("");
                th.setText("");
                fr.setText("");
                fv.setText("");
                layout.setAlpha(1);
            }};
public void views(){
    o=findViewById(R.id.gone);
    t=findViewById(R.id.gt);
    th=findViewById(R.id.gth);
    fr=findViewById(R.id.gf);
    fv=findViewById(R.id.gfv);
    a=findViewById(R.id.one);
    b=findViewById(R.id.two);
    c=findViewById(R.id.three);
    d=findViewById(R.id.four);
    e=findViewById(R.id.five);
    abc=findViewById(R.id.cone);
    cde=findViewById(R.id.ctwo);
    efg=findViewById(R.id.cthree);
    hij=findViewById(R.id.cfour);
    klm=findViewById(R.id.cfive);
layout=findViewById(R.id.l2);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.goals);
       views();
getSupportActionBar().hide();
        SharedPreferences getsharedPrefernces= getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String ab= getsharedPrefernces.getString("goal1", " ");
        String cd= getsharedPrefernces.getString("goal2", " ");
        String ef= getsharedPrefernces.getString("goal3", " ");
        String gh=getsharedPrefernces.getString("goal4", "  ");
        String ij= getsharedPrefernces.getString("goal5", " ");
        a.setText(ab);
        b.setText(cd);
        c.setText(ef);
        d.setText(gh);
        e.setText(ij);

    }

}