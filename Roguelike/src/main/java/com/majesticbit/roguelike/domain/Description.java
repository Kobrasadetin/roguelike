/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

/**
 *
 * @author Master
 */
public interface Description {

    /**
     * Textual description as String.
     *
     * @return description as String.
     */
    public String getText();

    /**
     *
     * @return char symbol.
     */
    public char getSymbol();
}
