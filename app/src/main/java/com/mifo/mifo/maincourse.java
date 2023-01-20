package com.mifo.mifo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class maincourse extends AppCompatActivity {
    int ab[]={R.drawable.nsgoreng,R.drawable.miegrng,R.drawable.nsuduk,
    R.drawable.sate,R.drawable.nasiayam};
    Button buton;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maincourse);

        recyclerView = findViewById(R.id.recycler1);
        Adapter adapter = new Adapter(this,ab,2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buton = findViewById(R.id.cek);

        buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(maincourse.this, checkout.class);
                startActivity(intent);
            }
        });
    }
}