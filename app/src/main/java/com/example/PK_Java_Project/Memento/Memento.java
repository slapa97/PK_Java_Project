package com.example.PK_Java_Project.Memento;

import com.example.PK_Java_Project.Container;
import com.example.PK_Java_Project.Products.Product;


public class Memento {
    private Container<Product> state;

    public Memento(Container<Product> state) {
        this.state = state;
    }

    public Container<Product> getState() {
        return state;
    }
}
