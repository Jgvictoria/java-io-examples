package com.victoria;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PlayWithPath {

    /*

    Why another model for a path?

    - the File class is here to stay for compatibility reason!
    - a File does not know the file system (it is file system independent)
    - no access to specific features

    Solution: one interface (Path) with specific implementations

    Give access to specific features of the file system
     This is why the Path interface was created

     - parent: everything before the last /
     - root: may not exist, file system dependent
     - absolute path: identified by the file system

     A file with a root element might not be an absolute path

     */
    public static void main(String[] args) {

        Path path1 = Paths.get("videos/../videos/../videos");
        Path path2 = Path.of("images/pngs/");

        System.out.println("path2 = " + path2);
        System.out.println("path1 = " + path1);
        System.out.println("path1 = " + path1.getClass());

        boolean absolute = path1.isAbsolute();
        System.out.println("absolute = " + absolute);

        Path root = path1.getRoot();
        System.out.println("root = " + root);

        Path resolve = path1.resolve(path2);
        System.out.println("resolve = " + resolve);

        Path path = path1.resolveSibling(path2);
        System.out.println("path = " + path);

        Path relativize = path1.relativize(path2);
        System.out.println("relativize = " + relativize);

        Path normalize = path1.normalize();
        System.out.println("normalize = " + normalize);

        Path path3 = Paths.get("files/images");
        FileSystem fileSystem = path3.getFileSystem();
        System.out.println("fileSystem = " + fileSystem);

    }
}
