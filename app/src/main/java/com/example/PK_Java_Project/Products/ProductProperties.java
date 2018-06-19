package com.example.PK_Java_Project.Products;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
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

    public long saveData(){
        long bytes = 0;

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        File file = new File(path, "data.txt");

        try {
            boolean exists = file.mkdirs();
            if(!file.exists())
                Log.e("save data", "dupa: " + exists + " "+ file.toString() );
            RandomAccessFile out = new RandomAccessFile(file, "rw");

            try {
                bytes = out.length();
                out.seek(bytes);
                out.writeUTF(name);
                out.writeUTF(description);
            } catch (IOException e){
                Log.e("save data", "File not found: " + e.toString());
            } finally {
                out.close();
            }
        } catch (IOException e) {
                Log.e("save data", "Can not read file: " + e.toString());
        }
        return bytes;

    }

    public static Product loadData(long offset){
        String name = null,
                description = null;
        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        File file = new File(path, "/" + "data.txt");
        try {
            RandomAccessFile in = new RandomAccessFile(file, "rw");
            try {
                in.seek(offset);
                name = in.readUTF();
                description = in.readUTF();
            } catch (IOException e) {
                Log.e("load data", "File not found: " + e.toString());
            } finally {
                in.close();
            }
        } catch (FileNotFoundException e) {
                Log.e("load data", "File not found: " + e.toString());
        } catch (IOException e) {
                Log.e("load data", "Can not read file: " + e.toString());
        }
        if(name != null && description != null)
            return new Sport(name, description);
        return  null;
    }

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
