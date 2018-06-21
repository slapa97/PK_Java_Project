package com.example.PK_Java_Project;

import android.content.Intent;

import com.example.PK_Java_Project.Memento.MementoModel;
import com.example.PK_Java_Project.ProductFactory.AutomotiveFactory;
import com.example.PK_Java_Project.ProductFactory.ClothesFactory;
import com.example.PK_Java_Project.ProductFactory.ElectronicFactory;
import com.example.PK_Java_Project.ProductFactory.ProductFactory;
import com.example.PK_Java_Project.ProductFactory.SportFactory;
import com.example.PK_Java_Project.Products.Product;

public class Model {
    private MementoModel mementoModel = new MementoModel();
    private Container<Product> products = new Container<>();
    public  Container<Product> createProduct(Intent data){
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
        }
        return products;
    }


    public Container<Product> getRecentMemento() {
        Container<Product> tmp = mementoModel.getRecentMemento();
        if(tmp != null)
            products = tmp;
        return products;
    }
    public Container<Product> getNextMemento() {
        Container<Product> tmp = mementoModel.getNextMemento();
        if (tmp != null)
            products = tmp;
        return products;
    }
}
