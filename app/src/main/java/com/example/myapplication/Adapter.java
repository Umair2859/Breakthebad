package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewholder> {
    ArrayList<image> arrayList;
    Context context;
    public Adapter(ArrayList arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.starss, parent, false);

        return new Adapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
image img= (image) arrayList.get(position);
        holder.mview.setAnimation(img.getImage1());
        holder.mview2.setAnimation(img.getImage2());
        holder.mview3.setAnimation(img.getImage3());
        holder.mview4.setAnimation(img.getImage4());
        holder.mview5.setAnimation(img.getImage5());

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class viewholder extends RecyclerView.ViewHolder{
        LottieAnimationView mview,mview2,mview3,mview4,mview5;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            mview=itemView.findViewById(R.id.im1);
            mview2=itemView.findViewById(R.id.im2);
            mview3=itemView.findViewById(R.id.im3);
            mview4=itemView.findViewById(R.id.im4);
            mview5=itemView.findViewById(R.id.im5);

        }

    }





}
