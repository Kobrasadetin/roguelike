/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import java.util.List;

/**
 *
 * @author Master
 */
public class EmptyContainer implements ItemContainer {

    @Override
    public List<Item> getItems() {
        throw new UnsupportedOperationException("Tried to access items in empty container.");
    }

    @Override
    public boolean hasItems() {
        return false;
    }

}
