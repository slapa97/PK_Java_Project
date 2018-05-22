package com.example.PK_Java_Project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class OneProduct extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_product);

        final EditText name_edit = (EditText) findViewById(R.id.edittext1);
        final EditText price_edit = (EditText) findViewById(R.id.edittext2);
        final EditText date_edit = (EditText) findViewById(R.id.edittext3);
        final EditText country_edit = (EditText) findViewById(R.id.edittext4);
        final EditText quantity_edit = (EditText) findViewById(R.id.edittext5);
        final Button button_one = (Button) findViewById(R.id.button_one);


        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_edit.getText().toString();
                int price = (Integer.parseInt(price_edit.getText().toString()));
                int date = (Integer.parseInt(date_edit.getText().toString()));
                String country = country_edit.getText().toString();
                int quantity = (Integer.parseInt(quantity_edit.getText().toString()));

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.putExtra("name", name);
                intent.putExtra("price", price);
                intent.putExtra("date", date);
                intent.putExtra("country", country);
                intent.putExtra("quantity", quantity);

                startActivity(intent);
            }
        });

    }
}