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
public class TileDescription implements Description {

    private String text;

    public TileDescription(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
