package com.example.PK_Java_Project.Products;

import java.time.LocalDate;

public class Sport extends ProductProperties implements Product {
    public Sport(//int buyYear, int buyMonth, int buyDay, int toYear, int toMonth, int toDay,
                 String name, String description) {
        //buyDate = LocalDate.of(buyYear, buyMonth, buyDay);
        //endOfUsingDate = LocalDate.of(toYear, toMonth, toDay);
        this.name = name;
        this.description = description;
    }
}
