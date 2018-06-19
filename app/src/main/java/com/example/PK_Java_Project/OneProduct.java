package com.example.PK_Java_Project;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.PK_Java_Project.Products.Product;
import com.example.PK_Java_Project.Products.Sport;


public class OneProduct extends AppCompatActivity {
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat
                    .requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    // Permission Denied
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
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
                requestPermission();
                long offset  = product.saveData();
                intent.putExtra("offset", offset);

                startActivity(intent);
            }
        });

    }
}