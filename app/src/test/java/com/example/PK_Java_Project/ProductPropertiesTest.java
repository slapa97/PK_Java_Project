package com.example.PK_Java_Project;

import com.example.PK_Java_Project.Products.Sport;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductPropertiesTest {
    @Test
    public void timeBetweenIsCorrect() throws Exception {
        Sport sp = new Sport(2018, 3, 10, 2018, 4, 11);
        Sport sp1 = new Sport(2018, 3, 10, 2018, 3, 10);
        Sport sp2 = new Sport(2010, 12, 10, 2018, 3, 11);

        assertEquals(0, sp.remainingTime().getYears());
        assertEquals(1, sp.remainingTime().getMonths());
        assertEquals(1, sp.remainingTime().getDays());

        assertEquals(0, sp1.remainingTime().getYears());
        assertEquals(0, sp1.remainingTime().getMonths());
        assertEquals(0, sp1.remainingTime().getDays());

        assertEquals(7, sp2.remainingTime().getYears());
        assertEquals(3, sp2.remainingTime().getMonths());
        assertEquals(1, sp2.remainingTime().getDays());
    }

}
