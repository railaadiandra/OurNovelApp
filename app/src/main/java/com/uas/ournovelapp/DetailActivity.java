package com.uas.ournovelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    //private Button btnlogout;

    ImageView imageViewsampulnovel;
    TextView textViewjudulnovel;
    TextView textViewinfoNovel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //btnlogout = findViewById(R.id.btn_logout);


        imageViewsampulnovel = findViewById(R.id.imageViewsampul);
        textViewjudulnovel = findViewById(R.id.textViewjudulnovel);
        textViewinfoNovel = findViewById(R.id.textViewinfoNovel);


        getIncomingExtra();
        //btnlogout.setOnClickListener(view -> {
            //FirebaseAuth.getInstance().signOut();
            //startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            //finish();
        //});
    }
    private void getIncomingExtra(){
        if (getIntent().hasExtra("sampul_novel")&& getIntent().hasExtra("judul_Novel")&& getIntent().hasExtra("info_Novel")){

            String sampulNovel = getIntent().getStringExtra("sampul_novel");
            String judulNovel = getIntent().getStringExtra("judul_Novel");
            String infoNovel = getIntent().getStringExtra("info_Novel");

            setDataActivity(sampulNovel, judulNovel, infoNovel);


        }
    }

    private void setDataActivity(String sampulNovel,String judulNovel,String infoNovel){

        Glide.with(this).asBitmap().load(sampulNovel).into(imageViewsampulnovel);


        textViewjudulnovel.setText(judulNovel);
        textViewinfoNovel.setText(infoNovel);


    }
}