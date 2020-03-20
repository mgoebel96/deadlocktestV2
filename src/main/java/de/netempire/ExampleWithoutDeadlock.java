package de.netempire;

import static java.lang.Thread.sleep;

public class ExampleWithoutDeadlock {

    private final Object printer = new Object();
    private final Object screen = new Object();

    public static void main(String[] args) {
        String[] output = startProcess();
        for (int i = 0; i < 4; i++) {
            System.out.println(output[i]);
        }
    }

    public static String[] startProcess() {
        final ExampleWithoutDeadlock deadLockDemo = new ExampleWithoutDeadlock();
        final String[] result = new String[4];
        Thread process_one = new Thread(new Runnable() {
            public void run() {
                synchronized (deadLockDemo.screen) {
                    try {
                        result[0] = "Process One hold Screen | wait -> Printer";
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (deadLockDemo.printer) {
                        result[1] = "Process One have Printer";
                    }
                }
            }
        });

        Thread process_two = new Thread(new Runnable() {
            public void run() {
                synchronized (deadLockDemo.screen) {
                    result[2] = "Process Two hold Screen | wait -> Printer";
                    synchronized (deadLockDemo.printer) {
                        result[3] = "Process Two hold Printer";
                    }
                }
            }
        });
        process_one.start();
        process_one.join();
        // Wartet bis Thread "tot" ist - Verhindert Deadlock
        process_two.start();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
