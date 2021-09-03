/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripto2021.hokkinon.viginere;

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
        for(int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                this.matrix[i][j] = (char) ('A' + (i + j) % sz);
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

                for(int k = 0; k < this.size; k++) {
                    checkValid(i, k);
                    checkValid(k, j);
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
        for(int k = 0; k < this.size; k++){
            if(k != i){
                this.valid[i][j] = this.valid[i][j] && (this.matrix[k][j] != this.matrix[i][j]);
            }
            if(k != j){
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

    public boolean[][] getValid(){ return this.valid; }

    //Encrypt
    public String encrypt(String plaintext, String key, boolean isAutokey, boolean includeSymbols) {
        StringBuilder str = new StringBuilder();
        int keysz = key.length();
        int textsz = plaintext.length();
        if (this.size != 256) {
            String textCopy = plaintext.toUpperCase();
            String keyCopy = key.toUpperCase();
            for (int idx = 0; idx < textsz; idx++) {
                char c = textCopy.charAt(idx);
                if('A' <= c && c <= 'Z') {
                    if(isAutokey) {
                        if(idx < keysz){
                            str.append(this.matrix[textCopy.charAt(idx - keysz) - 'A'][c - 'A']);
                        } else {
                            str.append(this.matrix[keyCopy.charAt(idx) - 'A'][c - 'A']);
                        }
                    } else {
                        str.append(this.matrix[keyCopy.charAt(idx % keysz) - 'A'][c - 'A']);
                    }
                } else if(includeSymbols) {
                    str.append(c);
                }
            }
        } else {
            for (int idx = 0; idx < key.length(); idx++) {
                char c = plaintext.charAt(idx);
                if (isAutokey) {
                    if(idx < keysz) {
                        str.append(this.matrix[plaintext.charAt(idx - keysz)][c]);
                    } else {
                        str.append(this.matrix[key.charAt(idx)][c]);
                    }
                } else {
                    str.append(this.matrix[key.charAt(idx % keysz)][c]);
                }
            }
        }
        return str.toString();
    }
}
