package de.netempire;

import static java.lang.Thread.sleep;

public class Example {

    private final Object printer = new Object();
    private final Object screen = new Object();

    public static void main(String[] args) throws InterruptedException {
        String[] output = startProcess();
        for (int i = 0; i < 4; i++) {
            System.out.println(output[i]);
        }
    }

    public static String[] startProcess() throws InterruptedException {
        final Example deadLockDemo = new Example();
        final String[] result = new String[4];
        final Thread process_one = new Thread(new Runnable() {
            public void run() {
                synchronized (deadLockDemo.screen) {
                    try {
                        result[0] = "Process One hold Screen | wait -> Printer";
                        sleep(1000);
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
                synchronized (deadLockDemo.printer) {
                    result[2] = "Process Two hold Printer | wait -> Screen";
                    synchronized (deadLockDemo.screen) {
                        result[3] = "Process Two hold Screen";
                    }
                }
            }
        });
        process_one.start();
 process_one.join();
// Wartet bis Thread "tot" ist
        process_two.start();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
