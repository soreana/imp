package org.sinsing.os.applications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sosin-PC on 7/13/2016.
 */
public class Terminal implements Application {
    private BufferedReader input;

    public Terminal(InputStream in) {
        InputStreamReader fileInputStream = new InputStreamReader(in);
        input = new BufferedReader(fileInputStream);
    }

    private void parseCommand() throws IOException {
        String rawInput;
        rawInput = input.readLine();
        String[] tempArray = rawInput.split(" ");
        String command = tempArray[0];
        if(tempArray.length <=1)
            return;
        ArrayList<String> options = new ArrayList<>();
        ArrayList<String> arguments = new ArrayList<>();

        int i = 1;
        while (tempArray[i].indexOf("-") == 0) {
            options.add(tempArray[i]);
            i++;
        }

        arguments.addAll(Arrays.asList(tempArray).subList(i, tempArray.length));

        System.out.println(rawInput);
        System.out.println(command);
        System.out.println(options);
        System.out.println(arguments);
    }

    private void close(){
        System.out.println("Bye.");
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                if (input.ready())
                    parseCommand();
            } catch (IOException ignored) {
            }
        }
        close();
    }
}
