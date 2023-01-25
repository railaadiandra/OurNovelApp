package com.uas.ournovelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> sampulNovel = new ArrayList<>();
    private ArrayList<String> judulNovel = new ArrayList<>();
    private ArrayList<String> infoNovel = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> sampulNovel, ArrayList<String> judulNovel, ArrayList<String> infoNovel, Context context) {
        this.sampulNovel = sampulNovel;
        this.judulNovel = judulNovel;
        this.infoNovel = infoNovel;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.desain_layout_adapter,parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(context).asBitmap().load(sampulNovel.get(position)).into(holder.imageViewsampulnovel);

        holder.textViewjudulnovel.setText(judulNovel.get(position));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ///Toast.makeText(context, judulNovel.get(position) , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("sampul_novel",sampulNovel.get(position));
                intent.putExtra("judul_Novel",judulNovel.get(position));
                intent.putExtra("info_Novel",infoNovel.get(position));

                context.startActivity(intent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return judulNovel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageViewsampulnovel;
        TextView textViewjudulnovel;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewsampulnovel = itemView.findViewById(R.id.imageViewsampul);
            textViewjudulnovel = itemView.findViewById(R.id.textViewjudulnovel);
            constraintLayout = itemView.findViewById(R.id.constraintlayout);



        }
    }
}
