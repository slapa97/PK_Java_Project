package com.example.PK_Java_Project.Products;

import java.time.Period;

public interface Product {
    String getName();

    double getQuantity();

    Period remainingTime();
}