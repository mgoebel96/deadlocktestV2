package de.netempire;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class ExampleDeadlockTest {

    @Test
    public void startProcess() {
        String[] result = new String[0];
        try {
            result = ExampleDeadlock.startProcess();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //It is checked whether the array is zero values.
        // If this is the case, the processes have been executed without errors.
        // Otherwise an error ( or deadlock ) has occurred.
        Stream<String> resultStream = Arrays.stream(result);
        resultStream.forEach((object) -> Assert.assertNotNull(object));
    }
}