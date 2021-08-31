/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripto2021.hokkinon.playfair;

import java.util.*;

/**
 *
 * @author PERSONAL
 */
public class Playfair {
    private static final String all = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    private String keyString;

    public Playfair(String keyString) {
        this.keyString = keyString;
    }
    
    public static String getKeyFrom(String text) {
        boolean[] isAdded = new boolean[26];
        StringBuilder temp = new StringBuilder("");
        
        for(char c: text.toUpperCase().toCharArray()) {
            int ascii = (int) c;
            if (!(ascii >= 65 && ascii <= 90)) continue;
            
            if (c == 'J') ascii--;
            
            if (isAdded[ascii - 65]) continue;                
            isAdded[ascii - 65] = true;

            temp.append((char)ascii);
        }
        
        for(char c: Playfair.all.toCharArray()) {
            int ascii = (int) c;
            if (isAdded[ascii - 65]) continue;
            
            temp.append(c);
        }
        
        String keyString = temp.toString();
        return keyString;
    }
    
    private String encode(String twoChars) {
        char[] res = new char[2];
        
        int first = this.keyString.indexOf(twoChars.toUpperCase().toCharArray()[0]);
        int i1 = first / 5, j1 = first % 5;
        
        int second = this.keyString.indexOf(twoChars.toUpperCase().charAt(1));
        int i2 = second / 5, j2 = second % 5;
        
        if (i1 == i2) {
            res[0] = this.keyString.charAt((i1 * 5) + ((j1 + 1) % 5));
            res[1] = this.keyString.charAt((i2 * 5) + ((j2 + 1) % 5));
        } else if (j1 == j2) {
            res[0] = this.keyString.charAt((((i1 + 1) % 5) * 5) + (j1));
            res[1] = this.keyString.charAt((((i2 + 1) % 5) * 5) + (j2));
        } else {
            // baris huruf pertama dan kolom huruf kedua
            res[0] = this.keyString.charAt(i1 * 5 + j2);
            // kolom huruf pertama dan baris huruf kedua
            res[1] = this.keyString.charAt(i2 * 5 + j1);
        }
        
        String low = new String(res).toLowerCase();
        char[] lowercaseChars = low.toCharArray();
        
        // convert both characters to their respective lower/upper case letter
        for(int i = 0; i <= 1; i++) {
            if (twoChars.charAt(i) >= 97 && twoChars.charAt(i) <= 122) {
                res[i] = lowercaseChars[i];
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(res[0]);
        result.append(res[1]);
        
        return result.toString();
    }
    
    public String encrypt(String text) {
        ArrayList<String> bigrams = new ArrayList<>();
        
        // convert the text to bigrams;
        for(int i = 0; i < text.length(); i++) {
            String temp = "";
            if (text.charAt(i) == 'J' || text.charAt(i) == 'j') temp += "i";
            else temp += text.charAt(i);
                
            if (i + 1 >= text.length()) {
                temp += "x";
            } else if (text.charAt(i + 1) == temp.toUpperCase().charAt(0) || text.charAt(i + 1) == temp.toLowerCase().charAt(0)) {
                temp += "x";
            } else {
                temp += text.charAt(++i);
            }
            bigrams.add(temp);
        }
        
        StringBuilder encrypted = new StringBuilder();
        for(String s: bigrams) {
            encrypted.append(this.encode(s));
        }
        return encrypted.toString();
    }
}
