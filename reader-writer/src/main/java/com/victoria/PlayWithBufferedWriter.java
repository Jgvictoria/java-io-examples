package com.victoria;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PlayWithBufferedWriter {

    public static void main(String[] args) {

        Path path = Path.of("files/words.txt");
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {

            bufferedWriter.write("Writing to a buffered writer");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
