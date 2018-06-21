package com.example.PK_Java_Project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.PK_Java_Project.Memento.MementoModel;
import com.example.PK_Java_Project.ProductFactory.*;
import com.example.PK_Java_Project.Products.Product;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Container<Product> products = new Container<>();
    private ListView lista;
    private MementoModel mementoModel = new MementoModel();
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String category = data.getStringExtra("category");
                Product product = null;
                if (category.equals("Automotive")) {
                    product = ProductFactory.createProduct(new AutomotiveFactory(
                            String.valueOf(data.getStringExtra("name")),
                            String.valueOf(data.getStringExtra("description")),
                            String.valueOf(data.getStringExtra("producent")),
                            String.valueOf(data.getStringExtra("model")),
                            data.getIntExtra("produceYear", 0),
                            String.valueOf(data.getStringExtra("color")),
                            String.valueOf(data.getStringExtra("country")),
                            data.getDoubleExtra("price", 0),
                            category,
                            data.getDoubleExtra("quantity", 0)
                    ));

                } else if (category.equals("Clothes")) {
                    product = ProductFactory.createProduct(new ClothesFactory(
                            String.valueOf(data.getStringExtra("name")),
                            String.valueOf(data.getStringExtra("description")),
                            String.valueOf(data.getStringExtra("size")),
                            String.valueOf(data.getStringExtra("color")),
                            String.valueOf(data.getStringExtra("country")),
                            data.getDoubleExtra("price", 0),
                            category,
                            data.getDoubleExtra("quantity", 0)
                    ));

                } else if (category.equals("Electronics")) {
                    product = ProductFactory.createProduct(new ElectronicFactory(
                            String.valueOf(data.getStringExtra("name")),
                            String.valueOf(data.getStringExtra("description")),
                            String.valueOf(data.getStringExtra("size")),
                            String.valueOf(data.getStringExtra("color")),
                            String.valueOf(data.getStringExtra("country")),
                            data.getDoubleExtra("price", 0),
                            category,
                            data.getDoubleExtra("quantity", 0)
                    ));
                } else if (category.equals("Sport")) {
                    product = ProductFactory.createProduct(new SportFactory(
                            String.valueOf(data.getStringExtra("name")),
                            String.valueOf(data.getStringExtra("description")),
                            String.valueOf(data.getStringExtra("color")),
                            String.valueOf(data.getStringExtra("country")),
                            data.getDoubleExtra("price", 0),
                            category,
                            data.getDoubleExtra("quantity", 0)
                    ));
                }

                if (product != null) {
                    products.add(product);
                    mementoModel.createMemento(products);
                    actualise();

                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);/// ten przycisk  po lewej  (<---)
        Button button3 = (Button) findViewById(R.id.button3);/// ten przycisk po prawej (--->)
        lista = (ListView) findViewById(R.id.lista);
        button.setOnClickListener(new View.OnClickListener() {
           
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OneProduct.class);
                startActivityForResult(intent, REQUEST_CODE);
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
           
            @Override
            public void onClick(View v) {
                Container<Product> tmp = mementoModel.getRecentMemento();
                if(tmp != null)
                    products = tmp;
                actualise();
            }

        });
      
        button3.setOnClickListener(new View.OnClickListener() {
           
            @Override
            public void onClick(View v) {
                Container<Product> tmp = mementoModel.getNextMemento();
                if(tmp != null)
                    products = tmp;
                actualise();
            }

        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
                intent.putExtra("details", products.get(position).getStringToDisplay());
                startActivity(intent);
            }
        });
    }


    private void actualise() {
        if(!products.isEmpty()) {
            SharedPreferences.Editor ProductsDetails = getApplicationContext().getSharedPreferences("ProductsDetails", Context.MODE_PRIVATE).edit();
            try {
                List<String> prodNames = new LinkedList<>();
                for (Product s : products) {
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

