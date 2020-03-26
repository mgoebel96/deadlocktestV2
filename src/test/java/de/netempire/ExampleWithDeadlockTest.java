package de.netempire;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ExampleWithDeadlockTest {

    @Test
    public void startProcess() {
        String[] result = new String[0];
        try {
            result = ExampleWithDeadlock.startProcess();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // contains a null value -> the program has deadlock -> test passed
        Assert.assertTrue(Arrays.asList(result).contains(null));
    }
}