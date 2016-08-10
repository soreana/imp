package org.sinsing.os.applications.terminal.commands;

/**
 * Created by sosin-PC on 8/10/2016.
 */
public class BadCommand extends Exception{
    private String message;
    public BadCommand(String s) {
        message = s;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
