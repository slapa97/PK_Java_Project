package com.example.PK_Java_Project.ProductFactory;

import com.example.PK_Java_Project.Products.Product;
import com.example.PK_Java_Project.Products.Sport;

public class SportFactory implements ProductAbstractFactory {
    private String name;
    private String category;

    public SportFactory(String name, String category) {
        this.category = category;
        this.name = name;
    }

    @Override
    public Product createProduct() {
        return new Sport(this.name, this.category);
    }
}
