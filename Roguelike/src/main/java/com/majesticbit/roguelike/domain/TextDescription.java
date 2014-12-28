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
public class TextDescription implements Description {

    private String text;
    private char symbol;
    private static final char DEFAULT_SYMBOL = '0';

    public TextDescription(String text) {
        this(text, DEFAULT_SYMBOL);
    }

    public TextDescription(String text, char symbol) {
        this.text = text;
        this.symbol = symbol;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
