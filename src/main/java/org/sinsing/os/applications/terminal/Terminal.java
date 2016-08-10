package org.sinsing.os.applications.terminal;

import org.sinsing.os.applications.Application;
import org.sinsing.os.applications.terminal.commands.Command;
import org.sinsing.os.applications.terminal.commands.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Terminal implements Application {
    private BufferedReader input;

    public Terminal(InputStream in) {
        InputStreamReader fileInputStream = new InputStreamReader(in);
        input = new BufferedReader(fileInputStream);
    }

    private Command parseCommand() throws IOException {
        String rawInput;
        rawInput = input.readLine();
        String[] tempArray = rawInput.split(" ");
        String command = tempArray[0];
        if(tempArray.length <=1)
            return CommandFactory.getCommand(command);
        ArrayList<String> options = new ArrayList<>();
        ArrayList<String> arguments = new ArrayList<>();

        int i = 1;
        while (tempArray[i].indexOf("-") == 0) {
            options.add(tempArray[i]);
            i++;
        }

        arguments.addAll(Arrays.asList(tempArray).subList(i, tempArray.length));

        return CommandFactory.getCommand(command,options,arguments);
    }

    private void close(){
        System.out.println("Bye.");
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                if (input.ready()) {
                    Command command = parseCommand();
                    String result = command.execute();
                    System.out.println(result);
                }
            } catch (IOException ignored) {
            }
        }
        close();
    }
}
