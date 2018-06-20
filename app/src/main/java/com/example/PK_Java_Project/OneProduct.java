package com.example.PK_Java_Project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class OneProduct extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_product);

        final EditText name_edit = (EditText) findViewById(R.id.edittext1);
        final EditText price_edit = (EditText) findViewById(R.id.edittext2);
        final EditText production_year_edit = (EditText) findViewById(R.id.edittext3);
        final EditText country_edit = (EditText) findViewById(R.id.edittext4);
        final EditText quantity_edit = (EditText) findViewById(R.id.edittext5);
        final EditText producent_edit = (EditText) findViewById(R.id.edittext6);
        final EditText description_edit = (EditText) findViewById(R.id.edittext7);
        final EditText colour_edit = (EditText) findViewById(R.id.edittext8);
        final EditText model_edit = (EditText) findViewById(R.id.edittext9);
        final EditText size_edit = (EditText) findViewById(R.id.edittext10);




        final Button button_one = (Button) findViewById(R.id.button_one);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner.getSelectedItem().toString().equals("Clothes")) {
                    country_edit.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                country_edit.setVisibility(View.INVISIBLE);
            }
        });


        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, country, category;
                int price, date, quantity;
                try {
                    name = name_edit.getText().toString();
                } catch (Exception e) {
                    name = "";
                }
                try {
                    price = (Integer.parseInt(price_edit.getText().toString()));
                } catch (Exception e) {
                    price = -1;
                }
                try {
                    date = (Integer.parseInt(production_year_edit.getText().toString()));
                } catch (Exception e) {
                    date = -1;
                }
                try {
                    country = country_edit.getText().toString();
                } catch (Exception e) {
                    country = "";
                }
                try {
                    quantity = (Integer.parseInt(quantity_edit.getText().toString()));
                } catch (Exception e) {
                    quantity = -1;
                }

                category = spinner.getSelectedItem().toString();



                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("date", date);
                intent.putExtra("country", country);
                intent.putExtra("quantity", quantity);
                intent.putExtra("category", category);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}