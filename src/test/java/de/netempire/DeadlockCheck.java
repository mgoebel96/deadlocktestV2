package de.netempire;

import org.junit.Assert;
import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadlockCheck {

    @Test
    public void startProcess() {
        String[] result = new String[0];
        try {
            result = ExampleWithDeadlock.startProcess();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        // Detect if the java program has occurred a deadlock.
        long[] threadIds = bean.findDeadlockedThreads();

        if (threadIds != null) {
            ThreadInfo[] infos = bean.getThreadInfo(threadIds);
            System.out.println("Your Programm has a Deadlock.");
            for (ThreadInfo info : infos) {
                System.out.println(info.toString());
            }
        } else {
            System.out.println("Your Programm has no Deadlock.");
        }
        Assert.assertNull(threadIds);
    }

}
