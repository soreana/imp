package org.sinsing.os.applications.terminal.commands;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 7/14/2016.
 */
public class CommandFactory {
    public static Command getCommand(String command, ArrayList<String> options , ArrayList<String> arguments){

        System.out.println(command);

        if("cp".equals(command))
            return new Copy(options,arguments);
        return null;
    }

    public static Command getCommand(String command) {
        return getCommand(command,null,null);
    }
}
