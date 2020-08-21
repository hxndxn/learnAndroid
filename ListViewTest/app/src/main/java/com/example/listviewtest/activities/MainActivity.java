package com.example.listviewtest.activities;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.listviewtest.Fruit;
import com.example.listviewtest.FruitAdapter;
import com.example.listviewtest.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruits = new ArrayList<>();
    {
        for(int i=0;i<10;i++){
            fruits.add(new Fruit(Character.toString((char)('a'+i)),i));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter adapter = new FruitAdapter(this,R.layout.fruit_item_layout,fruits);
        ((ListView)findViewById(R.id.list_view)).setAdapter(adapter);
    }


}