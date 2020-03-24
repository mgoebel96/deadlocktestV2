package de.netempire;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

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

        //Arrays.stream
        Stream<String> resultStream = Arrays.stream(result);
        resultStream.forEach((object) -> Assert.assertNotNull(object));
    }
}