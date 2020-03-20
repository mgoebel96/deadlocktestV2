package de.netempire;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import de.netempire.*;

import static org.junit.Assert.*;

public class ExampleWithoutDeadlockTest {

    @Test
    public void startProcess() {
        String[] result = ExampleWithoutDeadlock.startProcess();

        String[] i = {"Process One hold Screen | wait -> Printer",
                "Process One have Printer",
                "Process Two hold Screen | wait -> Printer",
                "Process Two hold Printer"};

        Assert.assertArrayEquals(i, result);
    }
}