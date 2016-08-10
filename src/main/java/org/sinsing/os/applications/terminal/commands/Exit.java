package org.sinsing.os.applications.terminal.commands;

import org.sinsing.os.OS;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 8/10/2016.
 */
public class Exit extends Command {
    public Exit(ArrayList<String> options, ArrayList<String> arguments) {
    }

    @Override
    public String execute() {
        OS.stop();
        return "exiting";
    }
}
