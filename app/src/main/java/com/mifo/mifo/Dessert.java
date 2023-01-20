package com.mifo.mifo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dessert extends AppCompatActivity {
    int gambar[]={R.drawable.coco,R.drawable.ice,R.drawable.martabak,R.drawable.kue,
            R.drawable.bijisalak};
    Button buton;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        recyclerView = findViewById(R.id.rec2);
        Adapter adapter = new Adapter(this,gambar,3);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buton = findViewById(R.id.cek);

        buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Dessert.this, checkout.class);
                startActivity(intent);
            }
        });

    }
}