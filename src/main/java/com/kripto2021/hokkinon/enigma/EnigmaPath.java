package com.kripto2021.hokkinon.enigma;

public class EnigmaPath {
    public String result;
    public int[] offset;
    public int[] forward;
    public int[] backward;

    public EnigmaPath(){
        result = "";
        offset = new int[0];
        forward = new int[0];
        backward = new int[0];
    }

    public EnigmaPath(String res, int[] off,  int[] fw, int[] bw){
        result = res;
        offset = off;
        forward = fw;
        backward = bw;
    }

}
