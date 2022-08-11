package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adaptorr extends RecyclerView.Adapter<adaptorr.viewholder> {
    ArrayList<Note> arrayList;
    Context context;

    public adaptorr(ArrayList arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rc, parent, false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Note note = (Note) arrayList.get(position);
        holder.mview.setText(note.getTask1());
        holder.mview2.setText(note.getTask2());
        holder.mview3.setText(note.getTask3());
        holder.mview4.setText(note.getTask4());
        holder.mview5.setText(note.getTask5());
        holder.mview6.setText(note.getTask6());
        holder.mview7.setText(note.getTask7());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class viewholder extends RecyclerView.ViewHolder{
        TextView mview,mview2,mview3,mview4,mview5,mview6,mview7;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            mview=itemView.findViewById(R.id.d1);
            mview2=itemView.findViewById(R.id.d2);
            mview3=itemView.findViewById(R.id.d3);
            mview4=itemView.findViewById(R.id.d4);
            mview5=itemView.findViewById(R.id.d5);
            mview6=itemView.findViewById(R.id.d6);
            mview7=itemView.findViewById(R.id.d7);

        }

    }

}
