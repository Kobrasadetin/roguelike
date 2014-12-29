/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.items;

import com.majesticbit.roguelike.domain.items.ItemContainer;
import com.majesticbit.roguelike.domain.items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Master
 */
public class TileContainer implements ItemContainer {

    private List<Item> items;

    public TileContainer()
    {
        items = new ArrayList();
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public boolean hasItems() {
        return !items.isEmpty();
    }

}
