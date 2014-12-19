/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.dungeonbuilder;

/**
 *
 * @author Master
 */
public class Room implements Element {

    private int x1, y1, x2, y2;

    public Room(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean isWall(int x, int y) {
        return (isInside(x, y) && isBoundary(x, y));
    }

    @Override
    public boolean isOpen(int x, int y) {
        return (isInside(x, y) && !isBoundary(x, y));
    }

    private boolean isInside(int x, int y) {
        if (x >= x1 && x <= x2) {
            if (y >= y1 && y <= y2) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoundary(int x, int y) {
        boolean wally = false;
        if (x == x1 || x == x2) {
            wally = true;
        }
        if (y == y1 || y == y2) {
            wally = true;
        }
        return wally;
    }

}
