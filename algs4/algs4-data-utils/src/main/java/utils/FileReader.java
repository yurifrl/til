package utils;

// import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
// import java.util.ArrayList;
import java.util.InputMismatchException;
// import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.google.common.base.Charsets;
import com.google.common.io.CharSource;

// https://introcs.cs.princeton.edu/java/stdlib/StdIn.java.html
public class FileReader implements Reader {
    protected Scanner scanner;

    protected void loadFile(String filename) throws IOException  {
        URL url = com.google.common.io.Resources.getResource(filename);
        CharSource charSource = com.google.common.io.Resources.asCharSource(url, Charsets.UTF_8);
        BufferedReader reader = charSource.openBufferedStream();
        scanner = new Scanner(reader);
    }

    public int readInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from standard input, "
                    + "but the next token is \"" + token + "\"");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(
                    "attemps to read an 'int' value from standard input, " + "but no more tokens are available");
        }
    }

    public boolean isEmpty() {
        return !scanner.hasNext();
    }
}
