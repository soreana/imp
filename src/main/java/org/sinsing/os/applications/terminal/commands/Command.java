package org.sinsing.os.applications.terminal.commands;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 7/13/2016.
 */

public abstract class Command {
    protected ArrayList<String> options;
    protected ArrayList<String> arguments;
    abstract public String execute();
}
