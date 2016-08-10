package org.sinsing.os.applications.terminal.commands;

import org.sinsing.os.applications.md5generator.MD5Generator;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 8/10/2016.
 */
public class MD5 extends Command {
    public MD5(ArrayList<String> options, ArrayList<String> arguments) {
        this.options = options;
        this.arguments = arguments;
    }

    @Override
    public String execute() {
        MD5Generator.start();
        MD5Generator.putString(arguments.get(0));
        String result;
        while (true) {
            try {
                Thread.sleep(10);
                result = MD5Generator.getResult(arguments.get(0));
                break;
            } catch (RuntimeException e) {
                if (!"result was not calculated.".equals(e.getMessage()))
                    throw new RuntimeException(e);
            } catch (InterruptedException e) {
                return null;
            }
        }
        return result;

    }
}