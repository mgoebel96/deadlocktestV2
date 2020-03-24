package de.netempire;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class ExampleDeadlockWithoutDeadlockTest {

    @Test
    public void startProcess() {
        String[] result = ExampleWithoutDeadlock.startProcess();

        //It is checked whether the array is zero values.
        // If this is the case, the processes have been executed without errors.
        // Otherwise an error ( or deadlock ) has occurred.
        Stream<String> resultStream = Arrays.stream(result);
        resultStream.forEach((object) -> Assert.assertNotNull(object));
    }
}