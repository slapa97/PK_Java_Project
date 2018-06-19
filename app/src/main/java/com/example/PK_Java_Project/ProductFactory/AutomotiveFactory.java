package com.example.PK_Java_Project.ProductFactory;

import com.example.PK_Java_Project.Products.Automotive;
import com.example.PK_Java_Project.Products.Product;

public class AutomotiveFactory implements ProductAbstractFactory {
    AutomotiveFactory() {
    }

    public Product createProduct() {
        return new Automotive() {
        };
    }
}
