/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.items;

import com.majesticbit.roguelike.domain.Description;

/**
 *
 * @author Master
 */
public interface Item {

    /**
     *
     * @return Description of the item
     */
    public Description getDescription();
}
