package com.mifo.mifo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Appetizer extends AppCompatActivity {
    int gambar[]={R.drawable.siomay,R.drawable.lumpia,R.drawable.wonton,R.drawable.bstahu,
    R.drawable.kroket};
    Button buton;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetizer);

        recyclerView = findViewById(R.id.textapp);
        Adapter adapter = new Adapter(this,gambar,1);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buton = findViewById(R.id.cek);

        buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Appetizer.this, checkout.class);
                startActivity(intent);
            }
        });
    }
}