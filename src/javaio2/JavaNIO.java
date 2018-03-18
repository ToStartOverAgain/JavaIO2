/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * @author daolinh
 */
public class JavaNIO {

    public static void main(String[] args) throws IOException {
        
    }

    public static void readFile() {
        Path path = Paths.get("test.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {//while there is content on the current line
                System.out.println(currentLine); // print the current line
            }
        } catch (IOException ex) {
            //handle an exception here

        }
    }

    public static void readAllLine() {
        Path path = Paths.get("test.txt");
        try {
            List<String> contents = Files.readAllLines(path);
            //Read from the stream
            for (String content : contents) {//for each line of content in contents
                System.out.println(content);// print the line
            }

        } catch (IOException ex) {
            //handle exception here           
        }
    }

    public static void writeFile() throws IOException {
        Path path = Paths.get("test.txt");

        String content = "Hello NIO.";

        Files.write(path, content.getBytes());
    }

    public static void writeFileBuffered() throws IOException {
        Path path = Paths.get("test.txt");

        String content = "Hello NIO Buffered.";

        BufferedWriter writer = null;
        if (Files.exists(path)) {
            writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.APPEND});
        } else {
            writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"), new OpenOption[]{StandardOpenOption.CREATE_NEW});
        }
        
        writer.write(content);
        writer.close();
    }

}
