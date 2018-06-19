package com.example.PK_Java_Project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.PK_Java_Project.Products.Sport;


public class OneProduct extends AppCompatActivity {
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;


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
        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_edit.getText().toString();
                //int price = (Integer.parseInt(price_edit.getText().toString()));
                //int date = (Integer.parseInt(date_edit.getText().toString()));
                //String country = country_edit.getText().toString();
                //int quantity = (Integer.parseInt(quantity_edit.getText().toString()));
                String category = spinner.getSelectedItem().toString();;

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Sport product = new Sport(name, category);
                long offset  = product.saveData();
                intent.putExtra("offset", offset);

                startActivity(intent);
            }
        });

    }
}