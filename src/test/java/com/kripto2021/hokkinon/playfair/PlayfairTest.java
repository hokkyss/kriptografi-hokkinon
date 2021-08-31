/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripto2021.hokkinon.playfair;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PERSONAL
 */
public class PlayfairTest {
    /**
     * Test of getKeyFrom method, of class Playfair.
     */
    @org.junit.jupiter.api.Test
    public void testGetKeyFrom() {
        System.out.println("getKeyFrom");
        String text = "jalanganeshasepuluh";
        String expResult = "IALNGESHPUBCDFKMOQRTVWXYZ";
        // IALNGESHPUBCDFKMOQRTVWXYZ
        String result = Playfair.getKeyFrom(text);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of encrypt method, of class Playfair.
     */
    @org.junit.jupiter.api.Test
    public void testEncrypt() {
        System.out.println("encrypt");
        String text = "TemuiIbuNantiMalam";
        Playfair instance = new Playfair("IALNGESHPUBCDFKMOQRTVWXYZ");
        String expResult = "MutelvEmpGlgmgOinlqv";
        
        String result = instance.encrypt(text);
        System.out.println(instance.encrypt("Temuiibunantimalam"));
        
        assertEquals(expResult, result);
    }
}
