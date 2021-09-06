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
    private long m;
    private long b;
    private final long n = 26; // 25252526
    
    public Affine(long m, long b) {
        this.m = m;
        this.b = b;
    }
        
    public long getM() {
        return this.m;
    }
    
    public long getB() {
        return this.b;
    }
    
    private static boolean validM(long m) {
        if (m == -1) return false;
        if (Utils.GCD(m, 26) == 1) return true;
        return false;
    }
    
    public static long[] getKeyFrom(String text) {
        String[] splitted = text.split(" ", 2);
        long m = -1;
        long b = -1;
                
        try {
            m = Long.parseLong(splitted[0]);
        } catch (NumberFormatException e) {
            if (splitted[0].length() == 1)
                m = (long)(splitted[0].toUpperCase().charAt(0) - 'A');
            else
                m = -1;
        } catch (Exception e) {
            m = -1;
        } finally {
            if (!Affine.validM(m)) m = -1;
        }

        try {
            b = Long.parseLong(splitted[1]);
        } catch (NumberFormatException e) {
            if (splitted[1].length() == 1)
                b = (long)(splitted[1].toUpperCase().charAt(0) - 'A');
            else
                b = -1;
        } catch (Exception e) {
            b = -1;
        }
        
        long[] result = new long[2];
        result[0] = m;
        result[1] = b;
        return result;
    }
    
    private char encode(char oneChar) {
        return (char)((m * (oneChar - 'A') + b) % this.n + 'A');
    }

    private char decode(char oneChar) {
        return (char)(((oneChar - 'A' + this.n - b) * Utils.moduloInverse(m,  this.n) % this.n) + 'A');
    }
    
    public String encrypt(String text) {
        if (this.b == -1 || this.m == -1) return "";

        char[] each = Utils.cleanString(text).toCharArray();
        StringBuilder builder = new StringBuilder();
        
        for(char c: each) {
            builder.append(encode(c));
        }
        return builder.toString();
    }
    public String decrypt(String text) {
        if (this.b == -1 || this.m == -1) return "";

        char[] each = Utils.cleanString(text).toCharArray();
        StringBuilder builder = new StringBuilder();

        for(char c: each) {
            builder.append(decode(c));
        }
        return builder.toString();
    }
}
