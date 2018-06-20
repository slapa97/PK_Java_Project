package com.example.PK_Java_Project.ProductFactory;

import com.example.PK_Java_Project.Products.Automotive;
import com.example.PK_Java_Project.Products.Product;

public class AutomotiveFactory implements ProductAbstractFactory {
    private String name;
    private String description;
    private int produceYear;
    private String model;
    private String producent;
    private String color;
    private String country;
    private double price;
    private String category;
    private double quantity;

    public AutomotiveFactory(String name, String description, String producent,
                             String model, int produceYear, String color,
                             String country, double price, String category, double quantity){
        this.name = name;
        this.description = description;
        this.producent = producent;
        this.model = model;
        this.produceYear = produceYear;
        this.color = color;
        this.country = country;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }
    public Product createProduct() {
        return new Automotive(name, description, producent,
                model, produceYear, color,
                country, price, category, quantity);
    }
}
