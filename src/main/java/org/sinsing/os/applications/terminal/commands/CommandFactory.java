package org.sinsing.os.applications.terminal.commands;

import org.sinsing.os.OS;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 7/14/2016.
 */
public class CommandFactory {
    public static Command getCommand(String command, ArrayList<String> options , ArrayList<String> arguments){

        if("cp".equals(command))
            return new Copy(options,arguments);
        else if ("md5".equals(command))
            return new MD5(options,arguments);
        else if ("exit".equals(command)) {
            return new Exit(options,arguments);
        }
        return new Command() {
            @Override
            public String execute() {
                return "Command not found.";
            }
        };
    }

    public static Command getCommand(String command) {
        return getCommand(command,null,null);
    }
}
