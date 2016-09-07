package org.sinsing.os.applications.terminal.commands;

import java.util.ArrayList;

/**
 * Created by sinakashipazha on 9/8/16.
 */
public abstract class NeedArgumentsCommand extends Command{
    protected NeedArgumentsCommand(ArrayList<String> options, ArrayList<String> arguments ,int minimumNumberOfArguments) throws BadCommand {
        super(options, arguments);
        if(arguments.size()<minimumNumberOfArguments)
            throw new BadCommand("insufficient arguments.");
    }
}
