package com.example.PK_Java_Project;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Container<T> implements Iterable<T> {
    private List<T> storage;
    public Container(){
        storage = new ArrayList<>();
    }
    public Container(Container container){this.storage = new ArrayList<>(container.storage);}
    public void add(T item){
        storage.add(item);
    }
    public T get(int index){
        return storage.get(index);
    }
    public boolean isEmpty(){
        return storage.isEmpty();
    }
    public int size(){
        return storage.size();
    }
    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < storage.size();
        }

        public T next(){
            return storage.get(index++);
        }

    }
}
