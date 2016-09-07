package org.sinsing.os.applications.terminal.commands;

import org.sinsing.os.applications.terminal.TerminalInterface;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 7/14/2016.
 */
public class CommandFactory {
    public static Command getCommand(String command, ArrayList<String> options,
                                     ArrayList<String> arguments, TerminalInterface terminal){

        String message = "Command not found.";

        try {
            if ("md5".equals(command))
                return new MD5(options, arguments,terminal);
            else if ("exit".equals(command))
                return new Exit(options, arguments,terminal);
            else if ("cd".equals(command))
                return new ChangeDirectory(options,arguments,terminal);
        }catch (BadCommand badCommand){
            message = badCommand.getMessage();
        }

        String finalMessage = message;

        return new Command(options,arguments) {
            @Override
            public String execute() {
                return finalMessage;
            }
        };
    }
}
