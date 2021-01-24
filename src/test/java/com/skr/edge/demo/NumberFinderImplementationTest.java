package com.skr.edge.demo;

import com.skr.edge.demo.model.CustomNumberEntity;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import static org.junit.Assert.*;

public class NumberFinderImplementationTest {

    @Test
    public void contains_success() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.json").getFile());
        NumberFinderImplementation numberFinderImplementation = new NumberFinderImplementation();
        List<CustomNumberEntity> list = numberFinderImplementation.readFromFile(file.getAbsolutePath());
        long start = System.currentTimeMillis();
        boolean found = numberFinderImplementation.contains(45, list);
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
        Assert.assertEquals(true, found);
    }

    @Test
    public void contains_nullValue() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test1.json").getFile());
        NumberFinderImplementation numberFinderImplementation = new NumberFinderImplementation();
        List<CustomNumberEntity> list = numberFinderImplementation.readFromFile(file.getAbsolutePath());
        boolean found = numberFinderImplementation.contains(2, list);
        Assert.assertEquals(false, found);
    }

    @Test
    public void contains_valueNotPresent() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.json").getFile());
        NumberFinderImplementation numberFinderImplementation = new NumberFinderImplementation();
        List<CustomNumberEntity> list = numberFinderImplementation.readFromFile(file.getAbsolutePath());
        long start = System.currentTimeMillis();
        boolean found = numberFinderImplementation.contains(2, list);
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("Execution time is " + formatter.format((end - start) / 1000d) + " seconds");
        Assert.assertEquals(false, found);

    }

    @Test
    public void readFromFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.json").getFile());
        NumberFinderImplementation numberFinderImplementation = new NumberFinderImplementation();
        numberFinderImplementation.readFromFile(file.getAbsolutePath());
    }
}