package com.example.PK_Java_Project;

import com.example.PK_Java_Project.ProductFactory.ProductAbstractFactory;
import com.example.PK_Java_Project.ProductFactory.SportFactory;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AbstractFactoryTest {
    @Test
    public void GeneralTest(ProductAbstractFactory factory, String name, String category){
        assertEquals(name, factory.createProduct().getName());
    }
    @Test
    public void SportTest(){
    //    GeneralTest(new SportFactory("sport", "sss"), "sport", "sss");
    }
}
