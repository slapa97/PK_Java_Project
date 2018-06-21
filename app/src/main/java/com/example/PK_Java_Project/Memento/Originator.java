package com.example.PK_Java_Project.Memento;

import com.example.PK_Java_Project.Container;
import com.example.PK_Java_Project.Products.Product;

public class Originator {
    private Container<Product> state;

    public Container<Product> getState() {
        return state;
    }

    public void setState(Container<Product> state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

