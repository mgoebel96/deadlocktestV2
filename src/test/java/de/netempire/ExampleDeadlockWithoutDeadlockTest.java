package de.netempire;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class ExampleDeadlockWithoutDeadlockTest {

    @Test
    public void startProcess() {
        String[] result = ExampleWithoutDeadlock.startProcess();

        //Es wird  überprüft, ob das Array, das man als Ergebnis erhält, frei von null-Werten ist.
        //Wenn das nicht der Fall ist, sind die Prozesse fehlerfrei abgearbeitet worden.
        //Andernfalls ist ein Fehler ( bzw. Deadlock) aufgetreten.
        Stream<String> resultStream = Arrays.stream(result);
        resultStream.forEach((object) -> Assert.assertNotNull(object));
    }
}