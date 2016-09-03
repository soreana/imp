package org.sinsing.os.applications.filesystem;

import org.sinsing.os.applications.Application;

import java.util.ArrayList;

/**
 * Created by sosin-PC on 8/12/2016.
 */
public class SinaiFileSystem implements Application{
    private String currentPath;
    private ArrayList<Folder> folders;

    private class Folder {
        private ArrayList<String> filesName;
        private ArrayList<Folder> folders;
    }

    @Override
    public void run() {

    }
}
