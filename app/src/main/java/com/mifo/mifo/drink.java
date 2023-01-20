package com.mifo.mifo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class drink extends AppCompatActivity {
    int gambar[]={R.drawable.air,R.drawable.lemon,R.drawable.soft,R.drawable.jus,
            R.drawable.kopi};
    Button buton;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        recyclerView = findViewById(R.id.rec3);
        Adapter adapter = new Adapter(this,gambar,4);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buton = findViewById(R.id.cek);

        buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(drink.this, checkout.class);
                startActivity(intent);
            }
        });
    }
}