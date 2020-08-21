package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Fruit> list = new ArrayList<>();
        for(int i = 0;i<3;i++){
            list.add(new Fruit("apple",R.drawable.apple));
            list.add(new Fruit("avocado",R.drawable.avocado));
            list.add(new Fruit("bananas",R.drawable.bananas));
            list.add(new Fruit("cherry",R.drawable.cherry));
            list.add(new Fruit("grapes",R.drawable.grapes));
            list.add(new Fruit("mango",R.drawable.mango));
            list.add(new Fruit("pineapple",R.drawable.pineapple));
            list.add(new Fruit("strawberry",R.drawable.strawberry));
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FruitAdapter(list));
    }
}