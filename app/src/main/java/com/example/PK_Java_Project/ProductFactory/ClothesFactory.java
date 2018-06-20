package com.example.PK_Java_Project.ProductFactory;

import com.example.PK_Java_Project.Products.Clothes;
import com.example.PK_Java_Project.Products.Product;

public class ClothesFactory implements ProductAbstractFactory {
    private String name;
    private String description;
    private String size;
    private String color;
    private String country;
    private double price;
    private String category;
    private double quantity;

    public ClothesFactory(String name, String description, String size, String color,
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
        return new Clothes(name, description, size, color, country, price,
        category, quantity);
    }
}
