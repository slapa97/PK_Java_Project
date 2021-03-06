package com.example.PK_Java_Project.ProductFactory;

import com.example.PK_Java_Project.Products.Product;
import com.example.PK_Java_Project.Products.Sport;

public class SportFactory implements ProductAbstractFactory {
    private String name;
    private String category;
    private String description;
    private String color;
    private String country;
    private double price;
    private double quantity;

    public SportFactory(String name, String description, String color,
                        String country, double price, String category, double quantity){
        this.name = name;
        this.description = description;
        this.color = color;
        this.country = country;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    @Override
    public Product createProduct() {
        return new Sport(name, description, color,
                country, price, category, quantity);
    }
}
