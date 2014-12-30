/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public class Position {

    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public void set(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void displace(Direction direction) {
        this.x += direction.deltaX;
        this.y += direction.deltaY;
    }

    public static Position displacedPosition(Position position, Direction direction) {
        Position newPosition = new Position(position);
        newPosition.displace(direction);
        return newPosition;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.x;
        hash = 59 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }

}
