package com.example.PK_Java_Project;
//importujemy
//test
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
//ss

import com.example.PK_Java_Project.ProductFactory.ProductFactory;
import com.example.PK_Java_Project.ProductFactory.SportFactory;
import com.example.PK_Java_Project.Products.Product;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LinkedList<Product> productList = new LinkedList<>();
    private ListView lista;
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (data.getStringExtra("name") != null) {
                    Product product = ProductFactory.createProduct(new SportFactory(
                            String.valueOf(data.getStringExtra("name")),
                            String.valueOf(data.getStringExtra("category"))));
                    productList.add(product);
                    actualise(lista);
                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        lista = (ListView) findViewById(R.id.lista);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OneProduct.class);
                startActivityForResult(intent, REQUEST_CODE);
            }

        });

        //List<String> list = new ArrayList<>();
        //list.add(String.valueOf(getIntent().getStringExtra("name")));
//            list.add("Cena:  " + String.valueOf(getIntent().getIntExtra("price", 0)));
//            list.add("Data: " + String.valueOf(getIntent().getIntExtra("date", 0)));
//            list.add(String.valueOf("Kraj: " + getIntent().getStringExtra("country")));
//            list.add(String.valueOf("Ilosc: " + getIntent().getIntExtra("quantity", 0)));
//            list.add(String.valueOf(getIntent().getStringExtra("category")));
    }


    private void actualise(ListView lista) {
        if(!productList.isEmpty()) {
            SharedPreferences.Editor ProductsDetails = getApplicationContext().getSharedPreferences("ProductsDetails", Context.MODE_PRIVATE).edit();
            try {
                List<String> prodNames = new LinkedList<>();
                for (Product s : productList) {
                    prodNames.add(s.getName());
                }
                lista.setAdapter(new ArrayAdapter<>(this, R.layout.list_row, prodNames.toArray()));
                String joined = TextUtils.join(" ", prodNames);
                ProductsDetails.putString("key", joined);
                ProductsDetails.apply();
            }catch(Exception e){
                Log.e("login activity", "error: " + e.toString());
            }
        }
    }

}

