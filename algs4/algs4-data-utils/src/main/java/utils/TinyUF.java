package utils;

import java.io.IOException;

// https://stackoverflow.com/questions/3891375/how-to-read-a-text-file-resource-into-java-unit-test
public class TinyUF extends FileReader {
    public TinyUF() throws IOException  {
        loadFile("tiny.txt");
    }
}
