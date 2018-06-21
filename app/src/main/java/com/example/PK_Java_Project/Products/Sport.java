package com.example.PK_Java_Project.Products;

public class Sport extends ProductProperties implements Product {
    public Sport(String name, String description, String color,
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
    public String getDescription() {
        return "Kategoria sport:\n" + description;
    }
}
