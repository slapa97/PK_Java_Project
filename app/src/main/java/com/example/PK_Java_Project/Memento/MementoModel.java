package com.example.PK_Java_Project.Memento;

import com.example.PK_Java_Project.Container;
import com.example.PK_Java_Project.Products.Product;

public class MementoModel {
    private Originator originator = new Originator();
    private CareTaker careTaker = new CareTaker();
    private int index = 0;
    private int size = 0;

    public void createMemento(Container<Product> list) {
        originator.setState(list);
        careTaker.add(originator.saveStateToMemento());
        index++;
        size++;
    }

    public Container<Product> getRecentMemento() {
        if (size > 0) {
            originator.getStateFromMemento(careTaker.get(--index));
            return originator.getState();
        } else
            return null;
    }

    public Container<Product> getNextMemento() {
        if (index < size - 1) {
            originator.getStateFromMemento(careTaker.get(++index));
            return originator.getState();
        } else
            return null;
    }
}
