package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class PlayWithBufferedReader {

    /*
    - Java I/O is built on the Decorator pattern

    - BufferedReader is a decorator of a Reader
    - read and write lines
    - writer supports charset
    - writer supports standard options

     */
    public static void main(String[] args) {

        Path path = Path.of("files/sonnet.txt");
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {


            /*
            String line = bufferedReader.readLine();

            while (line != null) {
                System.out.println("line = " + line);
                line = bufferedReader.readLine();
            }
             */

            Stream<String> lines = bufferedReader.lines();
            lines.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
