/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaio2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author daolinh
 */
public class CountryLang {

    private static HashMap<String, String> mapCountryLang;

    private static void generateMap() {
        mapCountryLang = new HashMap<>();
        try {
            List<String> listLine = Files.readAllLines(Paths.get("lang.txt"));
            for (String string : listLine) {
                String[] clArray = string.split("\\|");
                if (clArray.length > 1) {
                    mapCountryLang.put(clArray[0], clArray[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCountryLanguage(String lang) {
        if (mapCountryLang == null) {
            generateMap();
        }
        return mapCountryLang.get(lang);
    }
    
    public static void main(String[] args) {
        System.out.println(CountryLang.getCountryLanguage("ja"));
    }

}
