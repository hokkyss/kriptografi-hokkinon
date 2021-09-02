/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripto2021.hokkinon.affine;

import utils.Utils;
/**
 *
 * @author PERSONAL
 */
public class Affine {
    private long b;
    private long m;
    private final long n = 26; // 25252525
    
    public Affine(long b, long m) {
        this.b = b;
        this.m = m;
    }
    
    public static long[] getKeyFrom(String text) {
        String[] splitted = text.split(" ", 2);
        long b = Long.parseLong(splitted[0]);
        long m = Long.parseLong(splitted[1]);
        
        long[] result = new long[2];
        result[0] = b;
        result[1] = m;
        return result;
    }
    
    private char encode(char oneChar) {
        char c;
        
        return (char) ((char)((this.m * ((int)oneChar - 65)) % 26) + 65);
    }
    
    public String encrypt(String text) {
        char[] each = Utils.cleanString(text).toCharArray();
        StringBuilder builder = new StringBuilder();
        
        for(char c: each) {
            builder.append(encode(c));
        }
        return builder.toString();
    }
}
