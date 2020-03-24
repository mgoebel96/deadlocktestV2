package de.netempire;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class ExampleWithoutDeadlockTest {

    @Test
    public void startProcess() {
        String[] result = ExampleWithoutDeadlock.startProcess();

        String[] i = {"Process One hold Screen | wait -> Printer",
                "Process One have Printer",
                "Process Two hold Screen | wait -> Printer",
                "Process Two hold Printer"};

        //Arrays.stream
        Stream<String> resultStream = Arrays.stream(result);
        resultStream.forEach((object) -> Assert.assertNotNull(object));
    }
}