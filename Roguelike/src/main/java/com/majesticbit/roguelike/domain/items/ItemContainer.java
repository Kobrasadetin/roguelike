/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.items;

import java.util.List;

/**
 *
 * @author Master
 */
public interface ItemContainer {

    /**
     *
     * @return List containing all items in the container
     */
    public List<Item> getItems();
    
    /**
     *
     * @return true if the container has items
     */
    public boolean hasItems();
}
