package com.example.PK_Java_Project.Products;

public class Clothes extends ProductProperties implements Product {
    private String size;
    public Clothes(String name, String description, String size, String color,
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
    public String getDescription() {
        return "Kategoria odziez:\n" + description;
    }
}
