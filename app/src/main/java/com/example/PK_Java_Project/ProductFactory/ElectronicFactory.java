package com.example.PK_Java_Project.ProductFactory;

import com.example.PK_Java_Project.Products.Electronic;
import com.example.PK_Java_Project.Products.Product;

public class ElectronicFactory implements ProductAbstractFactory {
    private String size;
    private String description;
    private String country;
    private String color;
    private double price;
    private String name;
    private String category;
    private double quantity;
    public ElectronicFactory(String name, String description, String size, String color,
                             String country, double price, String category, double quantity){
        this.size = size;
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
        return new Electronic(name, description, size, color, country, price, category, quantity);
    }
}
