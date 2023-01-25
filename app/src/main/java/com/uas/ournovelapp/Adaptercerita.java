package com.uas.ournovelapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Adaptercerita extends RecyclerView.Adapter<Adaptercerita.MyViewHolder> {
    private List<Penghubung> mList;
    private Activity activity;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public Adaptercerita(List<Penghubung>mList, Activity activity){
        this.mList = mList;
        this.activity = activity;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewitem = inflater.inflate(R.layout.activity_detail,parent, false);
        return new MyViewHolder(viewitem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Penghubung data = mList.get(position);
        holder.textViewjudulnovel.setText(" Judul :" + data.getJudul());
        holder.textViewinfoNovel.setText(" Cerita :" + data.getCerita());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewjudulnovel,textViewinfoNovel;
        ImageView imageViewsampul;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewjudulnovel = itemView.findViewById(R.id.textViewjudulnovel);
            textViewinfoNovel = itemView.findViewById(R.id.textViewinfoNovel);
            imageViewsampul = itemView.findViewById(R.id.imageViewsampul);

        }
    }
}
