/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kripto2021.hokkinon;

/**
 *
 * @author PERSONAL
 */
public class ComboBoxItem {
    private final String label;

    ComboBoxItem(String label) {
        this.label = label;
    }
    
    @Override
    public String toString() {
        return this.label;
    }
}
