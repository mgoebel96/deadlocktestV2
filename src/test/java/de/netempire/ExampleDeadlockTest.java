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

        //Es wird  überprüft, ob das Array, das man als Ergebnis erhält, frei von null-Werten ist.
        //Wenn das nicht der Fall ist, sind die Prozesse fehlerfrei abgearbeitet worden.
        //Andernfalls ist ein Fehler ( bzw. Deadlock) aufgetreten.
        Stream<String> resultStream = Arrays.stream(result);
        resultStream.forEach((object) -> Assert.assertNotNull(object));
    }
}