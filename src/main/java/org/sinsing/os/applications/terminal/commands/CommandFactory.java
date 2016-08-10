package org.sinsing.os.applications.terminal.commands;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 7/14/2016.
 */
public class CommandFactory {
    public static Command getCommand(String command, ArrayList<String> options , ArrayList<String> arguments){
        String message = "Command not found.";

        try {
            if ("cp".equals(command))
                return new Copy(options, arguments);
            else if ("md5".equals(command))
                return new MD5(options, arguments);
            else if ("exit".equals(command)) {
                return new Exit(options, arguments);
            }
        }catch (BadCommand badCommand){
            message = badCommand.getMessage();
        }

        String finalMessage = message;

        return new Command() {
            @Override
            public String execute() {
                return finalMessage;
            }
        };
    }
}
