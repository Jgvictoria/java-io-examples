import java.io.Console;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PlayWithConsole {

    /*
    - the method printf calls format()
    - the console object is a singleton
    - calling writer() or reader() returns a uniques Writer or reader
    - calling close() on this reader and writer has no effect

    Scanner key points

    - a Scanner works with tokens and find()
    - it provides an Iterator or a Stream
    - it relies on regular expressions
    it does I/O buffering automatically
     */
    public static void main(String[] args) {

        // It is a singleton and synchronized
        Console console = System.console();

        PrintWriter writer = console.writer();
        writer.println("What is your name? > ");

        String name = console.readLine();
        writer.printf("Hello %s\n", name);
        writer.printf("What is your password %s?", name);

        char[] chars = console.readPassword();
        String password = new String(chars);
        writer.printf("%s is an easy password I guess! \n", password);
        writer.printf("What are your favorite colors %s?", name);
        String colors = console.readLine();

        List<String> providedColors = new Scanner(colors)
                .useDelimiter(" ")
                .tokens()
                .collect(Collectors.toList());
        writer.println(providedColors);

    }
}