package com.example.PK_Java_Project.ProductFactory;

import com.example.PK_Java_Project.Products.Product;

public class ProductFactory {
    public static Product createProduct(ProductAbstractFactory factory) {
        return factory.createProduct();
    }
}
