package com.victoria;

import java.io.File;
import java.io.IOException;

public class PlayWithFiles {

    /*
     A file object is independent of the file system.
     It is not liked to any file system, but it can be used to access it

     - create and delete files
     - create deletes
     - analyze the path
     - get the real path to a file or directory
     - With Files(another class), you can copy and move files
     */
    public static void main(String[] args) throws IOException {
        File file = new File("files/sonnet2.txt");

        boolean fileCreated = file.createNewFile();
        System.out.println("fileCreated = " + fileCreated);

        File dir = new File("files/data2/more-data");
        boolean dirCreated = dir.mkdir();
        System.out.println("dirCreated = " + dirCreated);
        boolean mkdirs = dir.mkdirs();
        System.out.println("mkdirs = " + mkdirs);

        boolean delete = dir.delete();
        System.out.println("delete = " + delete);

        dir = new File("images/.././mountain.png");
        String name = dir.getName();
        String parent = dir.getParent();
        String path = dir.getPath();

        System.out.println("name = " + name);
        System.out.println("parent = " + parent);
        System.out.println("path = " + path);

        //system depended
        String canonicalPath = dir.getCanonicalPath();
        System.out.println("canonicalPath = " + canonicalPath);
        String absolutePath = dir.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
    }
}