package org.sinsing.os.applications.terminal.commands;

import org.sinsing.os.applications.terminal.TerminalInterface;

import java.util.ArrayList;

/**
 * Created by sinakashipazha on 9/8/16.
 */
public class ChangeDirectory extends NeedArgumentsCommand{

    public ChangeDirectory(ArrayList<String> options,ArrayList<String> arguments, TerminalInterface terminal) throws BadCommand {
        super(options,arguments,1);
    }

    @Override
    public String execute() {
        return null;
    }
}
