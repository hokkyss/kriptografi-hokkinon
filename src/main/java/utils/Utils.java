/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Random;

/**
 *
 * @author PERSONAL
 */
public class Utils {
    public static long GCD(long a, long b) {
        if (a == 0) return b;
        return GCD(b % a, a);
    }
    /**
     * Counts a^-1 (mod m) using Bezout Identity
     * @see https://www.dcode.fr/bezout-identity
     * @param a
     * @param m
     * @return 
     */
    public static long moduloInverse(long a, long m) {
        assert(GCD(a, m) == 1);

        long r = a, r_ = m, u = 1, v = 0, u_ = 0, v_ = 1;
        while (r_ != 0) {
            long q = (long)r / r_;
            long tempr = r, tempu = u, tempv = v;
            r = r_; u = u_; v = v_;
            r_ = tempr - (q * r_); u_ = tempu - (q * u_); v_ = tempv - (q * v_);
        }
        // return r, u, v
        // r = GCD(a, m) = 1
        // v = a number such that au + mv = r
        
        while (u < 0) u += m;
        return u;
    }
    
    public static String cleanString(String s) {
        String caps = s.toUpperCase();
        StringBuilder builder = new StringBuilder();
        
        for(char c: caps.toCharArray()){
            if (c >= 'A' && c <= 'Z') {
                builder.append(c);
            }
        }
        return builder.toString();
    }
    
    public static String splitString(String s) {
        int len = s.length();

        String[] result = new String[(len + 4) / 5];
        
        for(int i = 0; i < (len + 4) / 5; i++) {
            result[i] = "";
            for(int j = 5*i; j < Math.min(len, 5*i+5); j++) {
                result[i] = result[i] + s.charAt(j);
            }
        }
        return String.join(" ", result);
    }
    public static String joinString(String s) {
        return String.join("", s.split(" "));
    }

    public static String randomPermutation(){
        boolean[] used = new boolean[26];
        for(int i=0; i<26; i++){
            used[i] = false;
        }
        StringBuilder str = new StringBuilder();
        Random rn = new Random();
        for(int i=0; i<26; i++){
            int chosen = rn.nextInt(26-i);
            int idx = 0;
            while(chosen>0 || used[idx]){
                if(!used[idx]){
                    chosen--;
                }
                idx++;
            }
            used[idx] = true;
            str.append((char)('A'+idx));
        }
        return str.toString();
    }

    public static String randomPairing(){
        char[] pair = new char[26];
        for(int i=0; i<26; i++){
            pair[i] = ' ';
        }
        Random rn = new Random();
        int paired = 0;
        for(int i=0; i<26; i++){
            if(pair[i] == ' '){
                int chosen = rn.nextInt(25-2*paired) + 1;
                int idx = 0;
                while(chosen>0 || pair[idx] != ' '){
                    if(pair[idx]==' '){
                        chosen--;
                    }
                    idx++;
                }
                pair[i] = (char) ('A'+idx);
                pair[idx] = (char) ('A'+i);
                paired++;
            }
        }
        return String.valueOf(pair);
    }
}
