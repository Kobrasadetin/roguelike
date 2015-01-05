/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.domain.creatures.actions.Action;

/**
 *
 * @author Master
 */
public interface PlayerInput {

    public Action getAction(Creature creature);
}
