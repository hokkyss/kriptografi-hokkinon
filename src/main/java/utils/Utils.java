/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

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
}
