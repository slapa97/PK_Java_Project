package com.example.PK_Java_Project;
//importujemy
//test
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.PK_Java_Project.Products.Product;
import com.example.PK_Java_Project.Products.ProductProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private LinkedList<Product> productList = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        try {
            if (getIntent().getLongExtra("offset", 0) >= 0) {
                Product product = ProductProperties.loadData(getIntent().getLongExtra("offset", 0));
                productList.addLast(product);
            }
        } catch (Exception e){

        }
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
//            list.add("Cena:  " + String.valueOf(getIntent().getIntExtra("price", 0)));
//            list.add("Data: " + String.valueOf(getIntent().getIntExtra("date", 0)));
//            list.add(String.valueOf("Kraj: " + getIntent().getStringExtra("country")));
//            list.add(String.valueOf("Ilosc: " + getIntent().getIntExtra("quantity", 0)));
//            list.add(String.valueOf(getIntent().getStringExtra("category")));

            String joined = TextUtils.join(" ", list);
            //productsSet.add(joined);
        }
        //lista.setAdapter(new ArrayAdapter<>(this, R.layout.list_row, productsSet.toArray()));
        if(!productList.isEmpty()) {
            SharedPreferences.Editor ProductsDetails = getApplicationContext().getSharedPreferences("ProductsDetails", Context.MODE_PRIVATE).edit();
            try {
                String name = productList.getLast().getName();
                ProductsDetails.putString("key", name);
                ProductsDetails.apply();
            }catch(Exception e){
                Log.e("login activity", "Can not read name: " + e.toString());
            }
        }
    }

}

