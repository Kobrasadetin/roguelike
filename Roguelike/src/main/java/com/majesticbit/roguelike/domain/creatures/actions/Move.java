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
    private final static float DIAGONAL_COST = 1.41f;

    public Move() {
        this.direction = Direction.NONE;
    }

    public Move(Direction direction) {
        this.direction = direction;
    }

    @Override
    public int calculateTimeUntilComplete(Creature creature) {
        if (!isDiagonal(this.direction)) {
            return creature.getProperties().getMovementDelay();
        } else {
            return (int) (creature.getProperties().getMovementDelay() * DIAGONAL_COST);
        }
    }

    @Override
    public void execute(Creature creature) {
        creature.addMovementToDirection(direction);
    }

    private boolean isDiagonal(Direction direction) {
        for (Direction diagonal : Direction.DIAGONALS) {
            if (direction.equals(diagonal)) {
                return true;
            }

        }
        return false;
    }

}
