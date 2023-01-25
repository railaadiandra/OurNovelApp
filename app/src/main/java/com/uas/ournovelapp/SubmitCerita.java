 package com.uas.ournovelapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.UUID;

 public class SubmitCerita extends AppCompatActivity {
    private EditText etJudul,etKotakCerita;
    private Button btn_submit;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_cerita);
        init();
    }
    private void init(){
        etJudul = findViewById(R.id.etJudul);
        etKotakCerita = findViewById(R.id.etKotakCerita);
        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getJudul = etJudul.getText().toString();
                String getCerita = etKotakCerita.getText().toString();

                if (getJudul.isEmpty()){
                    etJudul.setError("Masukan Judul..");
                }else if (getCerita.isEmpty()){
                    etKotakCerita.setError("Cerita Masih Kosong!");
                }else{
                    database.child("Cerita").push().setValue(new Penghubung(getJudul, getCerita)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(SubmitCerita.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SubmitCerita.this, MainActivity.class));
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SubmitCerita.this, "Gagal Menyimpan Data", Toast.LENGTH_SHORT).show();

                        }
                    });
                }



            }
        });
    }






}