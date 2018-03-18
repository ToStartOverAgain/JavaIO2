/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaio2;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author daolinh
 */
public class JavaIO2 {

    /**
     * @param args the command line arguments Internationalization -
     * localization
     */
    public static void main(String[] args) {
        System.out.println("Please choose your language (vi|en): ");
        Scanner sc = new Scanner(System.in);
        String lang = sc.nextLine();
        while (true) {
            Locale locale = new Locale(lang, CountryLang.getCountryLanguage(lang));
            ResourceBundle rb = ResourceBundle.getBundle("resource/lang", locale);
            System.out.println(rb.getString("hello"));
            System.out.println("Please choose your language (vi|en): ");
            lang = sc.nextLine();
        }
    }
}
