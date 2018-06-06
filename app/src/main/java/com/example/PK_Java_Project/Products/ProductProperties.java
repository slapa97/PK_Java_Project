package com.example.PK_Java_Project.Products;


import java.time.LocalDate;
import java.time.Period;


enum QuantityUnit {
    GRAM, METER, PIECE, LITRE
}

public abstract class ProductProperties {
    protected String description;
    protected String name;
    protected String category;
    protected LocalDate buyDate;
    protected LocalDate endOfUsingDate;
    protected double quantity;
    protected QuantityUnit quantityUnit;

    public String getName() {
        return name;
    }

    public Period remainingTime() {
        return Period.between(buyDate, endOfUsingDate);
    }

    public double getQuantity() {
        return quantity;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }
}
