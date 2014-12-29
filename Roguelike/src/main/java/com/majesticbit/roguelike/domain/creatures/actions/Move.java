/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures.actions;

import com.majesticbit.roguelike.domain.creatures.Creature;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public class Move extends Action {

    private Direction direction;

    public Move(Direction direction, int timeUntilComplete) {
        super(timeUntilComplete);
        this.direction = direction;        
    }
}
