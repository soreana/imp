package org.sinsing.os;

import org.sinsing.os.applications.terminal.Terminal;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 7/13/2016.
 */
public class OS {
    private static ArrayList<Thread> threads =
            new ArrayList<>();

    public static void start() {
        Thread temp = new Thread(new Terminal(System.in));
        threads.add(temp);
        temp.start();
    }

    public static void stop() {
        threads.forEach(Thread::interrupt);
    }
}
