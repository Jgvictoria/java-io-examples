package com.victoria;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class PlayWithWriter {

    /*

    - a writer must be closed
    - it can be flushed
    - it can write characters


     */

    public static void main(String[] args) {

        try (Writer writer = new FileWriter("files/words.txt")) {

            writer.write("Hello world!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
