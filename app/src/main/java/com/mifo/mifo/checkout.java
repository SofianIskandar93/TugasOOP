package com.mifo.mifo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class checkout extends AppCompatActivity {
    int []gambar = { R.drawable.siomay,R.drawable.lumpia,R.drawable.wonton,R.drawable.bstahu,
            R.drawable.kroket,R.drawable.nsgoreng,R.drawable.miegrng,R.drawable.nsuduk,
            R.drawable.sate,R.drawable.nasiayam,R.drawable.coco,R.drawable.ice,R.drawable.martabak,R.drawable.kue,
            R.drawable.bijisalak,R.drawable.air,R.drawable.lemon,R.drawable.soft,R.drawable.jus,
            R.drawable.kopi
    };

    String qr;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button buton;
        RecyclerView recyclerView;
        TextView textt;

        recyclerView = findViewById(R.id.recout5);

        Adapter adapter = new adapter2(this,gambar,5);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        int total = adapter2.total();
        textt = findViewById(R.id.total);
        String text2 = "Total = Rp. " + total;
        textt.setText(text2);
        qr = adapter2.qr();
        qr = qr + " " + total;

        buton = findViewById(R.id.checkout);
        buton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(checkout.this, qr.class);
                intent.putExtra("total",qr);
                startActivity(intent);
            }
        });
    }
}