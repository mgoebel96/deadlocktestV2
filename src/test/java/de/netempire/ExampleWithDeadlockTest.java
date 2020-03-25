package de.netempire;

import org.junit.Assert;
import org.junit.Test;

public class ExampleWithDeadlockTest {

    @Test
    public void startProcess() {
        String[] result = new String[0];
        try {
            result = ExampleWithDeadlock.startProcess();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //It is checked whether the array is zero values.
        // If this is the case, the processes have been executed without errors.
        // Otherwise an error ( or deadlock ) has occurred.
        for(int i = 0; i < 4; i++){
            Assert.assertNotEquals(null, result[i]);
            // contents a null value -> Error
        }
    }
}