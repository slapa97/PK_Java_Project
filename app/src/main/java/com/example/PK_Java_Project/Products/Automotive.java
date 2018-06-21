package com.example.PK_Java_Project.Products;

public class Automotive extends ProductProperties implements Product {
    private int produceYear;
    private String model;
    private String producent;
    public Automotive(String name, String description, String producent,
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

    @Override
    public String getDescription() {
        return "Kategoria motoryzacja:\n" + description;
    }
}