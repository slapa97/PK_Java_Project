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

import com.example.PK_Java_Project.Products.Product;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Container<Product> products = new Container<>();
    private ListView lista;
    public static final int REQUEST_CODE = 1;
    private Model model = new Model();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                products = model.createProduct(data);
                actualise();
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
                products = model.getRecentMemento();
                actualise();
            }

        });
      
        button3.setOnClickListener(new View.OnClickListener() {
           
            @Override
            public void onClick(View v) {
                products = model.getNextMemento();
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

