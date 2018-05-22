package com.example.PK_Java_Project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public Set<String> productsSet = new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("ProductsDetails", Context.MODE_PRIVATE);
        productsSet = sharedPreferences.getStringSet("key", Collections.<String>emptySet());
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), OneProduct.class);
                startActivity(intent);

            }

        });
        ListView lista = (ListView) findViewById(R.id.lista);
        List<String> list = new ArrayList<>();
        if (getIntent().getStringExtra("name") != null) {
            list.add(String.valueOf(getIntent().getStringExtra("name")));
            list.add("Cena:  " + String.valueOf(getIntent().getIntExtra("price", 0)));
            list.add("Data: " + String.valueOf(getIntent().getIntExtra("date", 0)));
            list.add(String.valueOf("Kraj: " + getIntent().getStringExtra("country")));
            list.add(String.valueOf("Ilosc: " + getIntent().getIntExtra("quantity", 0)));

            String joined = TextUtils.join(" ", list);
            productsSet.add(joined);
        }
        lista.setAdapter(new ArrayAdapter<>(this, R.layout.list_row, productsSet.toArray()));
        SharedPreferences.Editor ProductsDetails = getApplicationContext().getSharedPreferences("ProductsDetails", Context.MODE_PRIVATE).edit();
        ProductsDetails.putStringSet("key", productsSet);
        ProductsDetails.apply();
    }

}

