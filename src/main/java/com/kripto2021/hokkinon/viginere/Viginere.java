/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripto2021.hokkinon.viginere;

import utils.Utils;

/**
 *
 * @author PERSONAL
 */
public class Viginere {
    private int size;
    private char[][] matrix;
    private boolean[][] valid;

    public Viginere(int sz) {
        this.size = sz;
        this.matrix = new char[sz][sz];
        this.valid = new boolean[sz][sz];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(sz == 256){
                    this.matrix[i][j] = (char) ((i + j) % sz);
                }else{
                    this.matrix[i][j] = (char) ('A' + (i + j) % sz);
                }
                this.valid[i][j] = true;
            }
        }
    }

    public void randomize(){
        for(int i=0; i<26; i++){
            String str = Utils.randomPermutation();
            for(int j=0; j<26; j++){
                this.matrix[i][j] = str.charAt(j);
                this.valid[i][j] = true;
            }
        }
    }

    public void setMatrix(int i, int j, String val) {
        if(val.length() == 1) {
            char c = val.charAt(0);
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
                if ('a' <= c && c <= 'z') this.matrix[i][j] = (char) (c - 'a' + 'A');
                else this.matrix[i][j] = c;
                for (int k = 0; k < this.size; k++) {
                    checkValid(i,k);
                }
            } else {
                this.valid[i][j] = false;
            }
        } else {
            this.matrix[i][j] = ' ';
            this.valid[i][j] = false;
        }
    }
    public void checkValid(int i, int j) {
        this.valid[i][j] = (this.matrix[i][j] != ' ');
        for (int k = 0; k < this.size; k++) {
            if(k != j) {
                this.valid[i][j] = this.valid[i][j] && (this.matrix[i][k] != this.matrix[i][j]);
            }
        }
    }

    public boolean isMatrixValid() {
        boolean ret = true;
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < this.size; j++) {
                ret = ret && valid[i][j];
            }
        }
        return ret;
    }
    public char[][] getMatrix(){ return this.matrix; }
    public boolean[][] getValid(){ return this.valid; }
    
    private byte encode(byte c, char key) {
        return (byte)((int) this.matrix[key][(int)(c + 128)] - 128);
    }
    
    private char encode(char c, char key) {
        if (this.size != 256) {
            if ('A' <= c && c <= 'Z') return this.matrix[key - 'A'][c - 'A'];
            return c;
        } else {
            return this.matrix[key][c];
        }
    }
    private byte decode(byte c, char key) {
        return (byte)((int) this.matrix[(256 - key) % 256][(int)(c + 128)] - 128);
    }

    private char decode(char c, char key) {
        char[] row;
        
        if (this.size != 256) {
            row = this.matrix[key - 'A'];
            
            if ('A' <= c && c <= 'Z') return (char) ((char) String.valueOf(row).indexOf(c) + 'A');
            return c;
        }
        return this.matrix[(256 - key) % 256][c];
    }
    
    public byte[] encrypt(byte[] plaintext, String key) {
        byte[] result = new byte[plaintext.length];
        
        for(int i = 0; i < plaintext.length; i++) {
            result[i] = this.encode(plaintext[i], key.charAt(i % key.length()));
        }
        
        return result;
    }

    //Encrypt
    public String encrypt(String plaintext, String key, boolean isAutokey){
        if (key.length() == 0) return "";
        StringBuilder plaintextCopy = new StringBuilder();
        StringBuilder result = new StringBuilder();

        String upperCaseKey = key;
        if(size!=256){
            upperCaseKey = Utils.cleanString(key);;
            plaintext = Utils.cleanString(plaintext);
        }

        int keysz = key.length();
        int textsz = plaintext.length();
        
        for(int i = 0; i < textsz; i++) {
            char c = plaintext.charAt(i);
        
            if (isAutokey) {
                if (i >= keysz) {
                    result.append(this.encode(c, plaintext.charAt(i - keysz)));
                } else {
                    result.append(this.encode(c, upperCaseKey.charAt(i)));
                }
            } else {
                result.append(this.encode(c, upperCaseKey.charAt(i % keysz)));
            }
        }
        return result.toString();
    }
    
    public byte[] decrypt(byte[] ciphertext, String key) {
        byte[] result = new byte[ciphertext.length];
        
        for(int i = 0; i < ciphertext.length; i++) {
            result[i] = this.decode(ciphertext[i], key.charAt(i % key.length()));
        }
        
        return result;
    }
    public String decrypt(String ciphertext, String key, boolean isAutokey) {
        if (key.length() == 0) return "";
        StringBuilder result = new StringBuilder();
        
        String upperCaseKey = key.toUpperCase();
        if(size!=256){
            upperCaseKey = Utils.cleanString(key);;
            ciphertext = Utils.cleanString(ciphertext);
        }
        int keysz = key.length();
        int textsz = ciphertext.length();
        
        for(int i = 0; i < textsz; i++) {
            char c = ciphertext.charAt(i);
        
            if (isAutokey) {
                if (i >= keysz) {
                    result.append(this.decode(c, result.charAt(i - keysz)));
                } else {
                    result.append(this.decode(c, upperCaseKey.charAt(i)));
                }
            } else {
                result.append(this.decode(c, upperCaseKey.charAt(i % keysz)));
            }
        }
        return result.toString();
    }
}
