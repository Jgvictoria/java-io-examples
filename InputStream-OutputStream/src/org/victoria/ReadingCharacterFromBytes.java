package org.victoria;

import java.io.*;

public class ReadingCharacterFromBytes {

    /*

     OutputStreamReader and InputStreamWriter are readers and writers

     - act as bridged between the character world and the byte world
     */
    public static void main(String[] args) {
        String hello = "Hello world!";

        ByteArrayOutputStream buffer = null;

        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             OutputStreamWriter writer = new OutputStreamWriter(bos)) {

            writer.write(hello);
            buffer = bos;

        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = buffer.toByteArray();

        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
             InputStreamReader isr = new InputStreamReader(bis);
             BufferedReader reader = new BufferedReader(isr)) {

            String line = reader.readLine();
            System.out.println("line = " + line);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
