/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripto2021.hokkinon.enigma;

import utils.Utils;

/**
 *
 * @author PERSONAL
 */
public class Enigma {
    private int nbRotor;
    private char[][] rotor;
    private char[] mirror;
    private boolean[][] valid;

    public Enigma(int nbR){
        nbRotor = nbR;
        rotor = new char[nbR][26];
        mirror = new char[26];
        valid = new boolean[nbR+1][26];

        String str = Utils.randomPermutation();
        for(int i=0; i<nbRotor; i++){
            for(int j=0; j<26; j++){
                rotor[i][j] = str.charAt(j);
            }
            str = Utils.randomPermutation();
        }
        str = Utils.randomPairing();
        System.out.println(str);
        for(int i=0; i<26; i++){
            mirror[i] = str.charAt(i);
            valid[nbR][i] = true;
        }

    }

    public void validateAll(){

        for(int i=0; i<nbRotor; i++){
            for(int j=0; j<26; j++){
                valid[i][j] = (rotor[i][j]>='A' && rotor[i][j]<='Z');
            }
            for(int j=0; j<26; j++){
                for(int k=j+1; k<26; k++){
                    if(rotor[i][j] == rotor[i][k]){
                        valid[i][j] = false;
                        valid[i][k] = false;
                    }
                }
            }
        }
        for(int j=0; j<26; j++){
            valid[nbRotor][j] = (mirror[j] != ' ');
        }
        for(int j=0; j<26; j++){
            for(int k=j+1; k<26; k++){
                if(mirror[j] == mirror[k]){
                    valid[nbRotor][j] = false;
                    valid[nbRotor][k] = false;
                }
            }
        }
    }

    public void setValue(int i, int j, String val){
        char c = ' ';
        if(val.length() == 1){
            c = val.charAt(0);
        }
        if(i == nbRotor){
            mirror[j] = c;
        }else{
            rotor[i][j] = c;
        }
        validateAll();
    }
    public char[][] getRotor() {
        return rotor;
    }
    public char[] getMirror() {
        return mirror;
    }
    public boolean[][] getValid() {
        return valid;
    }

    public EnigmaPath encryptChar(char c, int rotorItr){
        int[] fw = new int[nbRotor+1];
        int[] bw = new int[nbRotor+1];
        int[] offset = new int[nbRotor+1];
        offset[nbRotor] = 0;
        for(int i=nbRotor-1; i>=0; i--){
            offset[i] = rotorItr % 26;
            rotorItr /= 26;
        }
        //Maju
        fw[0] = (c+offset[0]-'A')%26;
        for(int i=0; i<nbRotor; i++){
            c = rotor[i][fw[i]];
            fw[i+1] = (c+offset[i+1]-'A')%26;
        }
        //Mirror
        c = mirror[fw[nbRotor]];
        bw[nbRotor] = c - 'A';
        //Mundur
        for(int i=nbRotor-1; i>=0; i--){
            boolean notfound = true;
            for(int j=0; j<26 && notfound; j++){
                if(rotor[i][j] == c){
                    c = (char)('A' + (j+26-offset[i])%26);
                    notfound = false;
                }
            }
            bw[i] = (c+offset[i]-'A')%26;
        }
        return new EnigmaPath(String.valueOf(c), offset, fw, bw);
    }

    public EnigmaPath encrypt(String text, String key){
        text = Utils.cleanString(text);
        EnigmaPath ret = new EnigmaPath();
        StringBuilder str = new StringBuilder();
        int rotorItr=0, mul=1;
        for(int i=key.length(); i>0; i--){
            rotorItr += mul*(key.charAt(i-1) - 'A');
            mul *= 26;
        }
        for(int i=0; i<text.length(); i++){
            ret = encryptChar(text.charAt(i), rotorItr+i);
            str.append(ret.result);
        }
        ret.result = str.toString();
        return ret;
    }
    
    public EnigmaPath decrypt(String text, String key) {
        return this.encrypt(text, key);
    }
}
