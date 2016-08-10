package org.sinsing.os.applications.terminal.commands;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 7/13/2016.
 */

public class Copy extends Command {
    public Copy(ArrayList<String> options, ArrayList<String> arguments) {
        System.out.println(options);
        System.out.println(arguments);
    }

    @Override
    public String execute() {
        System.out.println("I'm executing.");
        return null;
    }
}
