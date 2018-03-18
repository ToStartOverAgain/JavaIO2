/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author daolinh
 */
public class JavaNIODemo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("test.txt");
//        Files.exists(path);
        
        List<String> lines = Files.readAllLines(path);
        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }
    }
}
