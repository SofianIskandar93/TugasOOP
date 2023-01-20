package com.mifo.mifo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ordering extends AppCompatActivity {

    Button Aps;
    Button Main;
    Button Des;
    Button Drink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordering);
        //For Appetizer
        Aps = findViewById(R.id.Apps);
        Aps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Ordering.this, Appetizer.class);
                startActivity(intent);
            }
        });

        //For Main
        Main = findViewById(R.id.maincourse);

        Main.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Ordering.this, maincourse.class);
                startActivity(intent);
            }
        });

        //For Desert
        Des = findViewById(R.id.dessert);

        Des.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Ordering.this, Dessert.class);
                startActivity(intent);
            }
        });

        //For Drinks
        Drink= findViewById(R.id.drink);

        Drink.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Ordering.this, drink.class);
                startActivity(intent);
            }
        });



    }
}