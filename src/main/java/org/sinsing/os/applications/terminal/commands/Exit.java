package org.sinsing.os.applications.terminal.commands;

import org.sinsing.os.OS;
import org.sinsing.os.applications.terminal.TerminalInterface;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 8/10/2016.
 */
public class Exit extends Command {
    public Exit(ArrayList<String> options, ArrayList<String> arguments, TerminalInterface terminal) {
    }

    @Override
    public String execute() {
        OS.stop();
        return "exiting";
    }
}
