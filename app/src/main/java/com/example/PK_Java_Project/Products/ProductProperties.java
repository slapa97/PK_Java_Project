package com.example.PK_Java_Project.Products;


import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public abstract class ProductProperties {
    protected String description;
    protected String name;
    protected double price;
    protected String country;
    protected String color;
    protected String category;
    protected double quantity;

    public String getName() {
        return name;
    }
    public String getDescription(){return description;}
    public String getCategory() { return category; }
    public double getQuantity() {
        return quantity;
    }
    public double getPrice(){return price;}
    public String getCountry(){return country;}
    public String getColor() {return color;}
}

    //    public long saveData(){
//        long bytes = 0;
//
//        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
//        File file = new File(path, "data.txt");
//
//        try {
//            boolean exists = file.mkdirs();
//            if(!file.exists())
//                Log.e("save data", "dupa: " + exists + " "+ file.toString() );
//            RandomAccessFile out = new RandomAccessFile(file, "rw");
//
//            try {
//                bytes = out.length();
//                out.seek(bytes);
//                out.writeUTF(name);
//                out.writeUTF(description);
//            } catch (IOException e){
//                Log.e("save data", "File not found: " + e.toString());
//            } finally {
//                out.close();
//            }
//        } catch (IOException e) {
//                Log.e("save data", "Can not read file: " + e.toString());
//        }
//        return bytes;
//
//    }
//
//    public static Product loadData(long offset){
//        String name = null,
//                description = null;
//        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
//        File file = new File(path, "/" + "data.txt");
//        try {
//            RandomAccessFile in = new RandomAccessFile(file, "rw");
//            try {
//                in.seek(offset);
//                name = in.readUTF();
//                description = in.readUTF();
//            } catch (IOException e) {
//                Log.e("load data", "File not found: " + e.toString());
//            } finally {
//                in.close();
//            }
//        } catch (FileNotFoundException e) {
//                Log.e("load data", "File not found: " + e.toString());
//        } catch (IOException e) {
//                Log.e("load data", "Can not read file: " + e.toString());
//        }
//        if(name != null && description != null)
//            return new Sport(name, description);
//        return  null;
//    }
//}
