package com.example.PK_Java_Project;



import com.example.PK_Java_Project.Memento.MementoModel;
import com.example.PK_Java_Project.Products.Product;
import com.example.PK_Java_Project.Products.ProductProperties;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testcontainer() throws Exception {
        Container<String> cont = new Container<>();
        String[] strings = {"jeden", "dwa, trzy"};
        for (String s : strings)
            cont.add(s);
        Iterator it = cont.iterator();
        int index = 0;
        while (it.hasNext())
            assertEquals(strings[index++], it.next());
    }
    @Test
    public void testContainerSize() throws Exception{
        Container<String> cont = new Container<>();
        String[] strings = {"jeden", "dwa, trzy"};
        for (String s : strings)
            cont.add(s);
        assertEquals(2, cont.size());
    }
    @Test
    public void testContainerWorksEmpty() throws Exception{
        Container<Integer> cont = new Container<>();
        System.out.println(cont.isEmpty());
        assertTrue(cont.isEmpty());
    }

    @Test
    public void AdditionIsCorrect(){
        assertEquals(4, 2+2);
    }

    private class SimpleProduct extends ProductProperties implements Product {
        @Override
        public String getStringToDisplay() {
            return null;
        }
        SimpleProduct(){}
    }
    @Test
    public void testRecentMemento(){

        MementoModel mm = new MementoModel();
        Container<Product> cont = new Container<>();
        cont.add(new SimpleProduct());
        mm.createMemento(cont);
        cont.add(new SimpleProduct());
        mm.createMemento(cont);
        Container<Product> saved = new Container<>(cont);
        cont.add(new SimpleProduct());
        mm.createMemento(cont);
        Container<Product> prev = mm.getRecentMemento();
        Iterator it1 = saved.iterator();
        Iterator it2 = prev.iterator();
        while(it1.hasNext())
            assertEquals(it1.next(), it2.next());
    }
    @Test
    public void testNextMemento(){

        MementoModel mm = new MementoModel();
        Container<Product> cont = new Container<>();
        cont.add(new SimpleProduct());
        mm.createMemento(cont);
        cont.add(new SimpleProduct());
        mm.createMemento(cont);
        cont.add(new SimpleProduct());
        mm.createMemento(cont);
        Container<Product> saved = new Container<>(cont);
        cont.add(new SimpleProduct());
        mm.createMemento(cont);
        Container<Product> next, saved2;
        saved = mm.getRecentMemento();
        saved2 = mm.getRecentMemento();
        next = mm.getNextMemento();
        Iterator it1 = saved.iterator();
        Iterator it2 = next.iterator();
        while(it1.hasNext())
            assertEquals(it1.next(), it2.next());
    }

    //@Test
    //public void AdditionIsCorrect(){
    //    assertEquals(4, 1+2);
    //}






}
