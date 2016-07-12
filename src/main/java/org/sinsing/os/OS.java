package org.sinsing.os;

import org.sinsing.os.applications.terminal.Terminal;

/**
 * Created by sosin-PC on 7/13/2016.
 */
public class OS {
    public static void start(){
        try {
            Thread terminator = new Thread(new Terminal(System.in));
            terminator.start();
            Thread.sleep(10000);
            terminator.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
