package com.app.fruit_learning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set the list feature of fruits
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(getString(R.string.apple),R.mipmap.apple,R.color.red));
        fruits.add(new Fruit(getString(R.string.cherry),R.mipmap.cherry,R.color.red));
        fruits.add(new Fruit(getString(R.string.strawberry),R.mipmap.strawberry,R.color.red));
        fruits.add(new Fruit(getString(R.string.banana),R.mipmap.banana,R.color.yellow));
        fruits.add(new Fruit(getString(R.string.lemon),R.mipmap.lemon,R.color.yellow));
        fruits.add(new Fruit(getString(R.string.mango),R.mipmap.mango,R.color.yellow));
        fruits.add(new Fruit(getString(R.string.avocado),R.mipmap.avocado,R.color.green));
        fruits.add(new Fruit(getString(R.string.grape),R.mipmap.grape,R.color.green));
        fruits.add(new Fruit(getString(R.string.waterlemon),R.mipmap.watermelon,R.color.green));

        FruitAdapter adapter = new FruitAdapter(fruits);
        recyclerView.setAdapter(adapter);


        //turn to different page
        findViewById(R.id.main_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FruitActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}