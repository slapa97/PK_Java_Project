package com.example.PK_Java_Project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Piotrek on 6/21/2018.
 */

public class ProductDetails extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);
        TextView textViewDetails = (TextView) findViewById(R.id.text_details);
        String details = getIntent().getStringExtra("details");
        try {
            textViewDetails.setText(details);
        }catch(NullPointerException e){
            Log.e("details : " , details);
        }
    }
}
