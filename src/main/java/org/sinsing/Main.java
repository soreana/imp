package org.sinsing;

import org.sinsing.os.OS;
import org.sinsing.os.applications.filesystem.SinaiFileSystem;
import org.sinsing.os.applications.md5generator.MD5Generator;

import java.math.BigDecimal;

/**
 * Created by sosin-PC on 7/9/2016.
 */
public class Main {
    public static void main( String [] args) throws InterruptedException {
        SinaiFileSystem.start();
        OS.start();

        /*
        MD5Generator.start();

        MD5Generator.putString("ANOooOSHA");
        Thread.sleep(100);
        System.out.println("MD5 is: " + MD5Generator.getResult("ANOooOSHA"));

        MD5Generator.stop();
        */
    }
}
