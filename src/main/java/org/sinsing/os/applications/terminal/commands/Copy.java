package org.sinsing.os.applications.terminal.commands;

import org.sinsing.os.applications.terminal.TerminalInterface;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 7/13/2016.
 */

public class Copy extends Command {
    public Copy(ArrayList<String> options, ArrayList<String> arguments, TerminalInterface terminal) {
        System.out.println(options);
        System.out.println(arguments);
    }

    @Override
    public String execute() {
        System.out.println("I'm executing.");
        return null;
    }
}
