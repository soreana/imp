package org.sinsing.os;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by sosin-PC on 7/14/2016.
 */
public class OSTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream in = new ByteArrayInputStream("cp -r hello world.".getBytes());

    @org.junit.Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(in);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.setOut(null);
        System.setErr(null);
        System.setIn(System.in);
    }

    @org.junit.Test
    public void start() throws Exception {
        OS.start();
        assertEquals("cp\r\n[-r]\r\n[hello, world.]\r\nI'm executing.\r\n", outContent.toString());
    }

}