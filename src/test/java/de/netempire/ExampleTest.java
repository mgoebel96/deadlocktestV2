package de.netempire;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import de.netempire.*;

import static org.junit.Assert.*;

public class ExampleTest {

    @Test
    public void startProcess() {
        String[] result = new String[0];
        try {
            result = Example.startProcess();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String[] i = {"Process One hold Screen | wait -> Printer",
                "Process One have Printer",
                "Process Two hold Screen | wait -> Printer",
                "Process Two hold Printer"};

        Assert.assertArrayEquals(i, result);
    }
}