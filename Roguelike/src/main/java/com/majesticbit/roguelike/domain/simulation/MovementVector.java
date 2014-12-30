/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.simulation;

import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public class MovementVector {

    public float x;
    public float y;

    public void addMovementToDirection(Direction direction) {
        this.x += direction.deltaX;
        this.y += direction.deltaY;
    }

    public boolean potentiallyMoving() {
        if (x >= 1f || y >= 1f) {
            return true;
        }
        if (x <= -1f || y <= -1f) {
            return true;
        }
        return false;
    }

    public Direction performDisplacement() {
        Direction displacement = Direction.getDirection((int) x, (int) y);
        x = x - displacement.deltaX;
        y = y - displacement.deltaY;
        return displacement;
    }

}
