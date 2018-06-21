package com.example.PK_Java_Project.Products;


public abstract class ProductProperties {
    protected String description;
    protected String name;
    protected double price;
    protected String country;
    protected String color;
    protected String category;
    protected double quantity;

    public String getName() {
        return name;
    }
    public String getDescription(){return description;}
    public String getCategory() { return category; }
    public double getQuantity() {
        return quantity;
    }
    public double getPrice(){return price;}
    public String getCountry(){return country;}
    public String getColor() {return color;}
}

