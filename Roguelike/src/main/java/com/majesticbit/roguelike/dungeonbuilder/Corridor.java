/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.dungeonbuilder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Master
 */
public class Corridor implements Element {

    //TODO: better implementation of corridors
    private boolean[][] walls;
    private boolean[][] empty;

    //we want a corridor from point (x1,y1) to (x2,y2)
    private int x1, x2, y1, y2;
    private Point displacement;
    private Point size;

    public Corridor(int x1, int y1, int x2, int y2) {
        //we always build corridors from left to right, so that x1<=x2
        if (x2 < x1) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        //we always build corridors from top to bottom, so that y1<=y2
        if (y2 < y1) {
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        displacement = new Point(x1 - 1, y1 - 1);
        size = new Point(x2 - x1 + 3, y2 - y1 + 3);
        walls = new boolean[size.x][size.y];
        empty = new boolean[size.x][size.y];
        mapTheCorridor();
    }

    @Override
    public boolean isWall(int x, int y) {
        x -= displacement.x;
        y -= displacement.y;
        if (isInBounds(x, y)) {
            return (walls[x][y]);
        }
        return false;
    }

    @Override
    public boolean isOpen(int x, int y) {
        x -= displacement.x;
        y -= displacement.y;
        if (isInBounds(x, y)) {
            return (empty[x][y]);
        }
        return false;
    }

    private Point absoluteToMap(Point point) {
        return (new Point(point.x - displacement.x, point.y - displacement.y));
    }

    private Point absoluteToMap(int x, int y) {
        return (new Point(x - displacement.x, y - displacement.y));
    }

    //?do we need private Point mapToAbsolute(Point point) {}
    private void mapTheCorridor() {
        Point current = absoluteToMap(x1, y1);
        Point target = absoluteToMap(x2, y2);
        boolean cont = true;
        while (cont) {
            dig(current);
            if (xDistanceGreater(current.x, current.y, target.x, target.y)) {
                current.x++;
            } else {
                current.y++;
            }
            if (current.x == target.x && current.y == target.y) {
                cont = false;
            }
        }
    }

    private static boolean xDistanceGreater(int x, int y, int tx, int ty) {
        if (tx - x > ty - y) {
            return true;
        }
        return false;
    }

    private void dig(Point location) {
        int x = location.x;
        int y = location.y;
        empty[x][y] = true;

        for (int tx = x - 1; tx < x + 2; tx++) {
            for (int ty = y - 1; ty < y + 2; ty++) {
                walls[tx][ty] = true;
            }
        }
    }

    private boolean isInBounds(int x, int y) {
        if ((x >= 0 && x < size.x) && (y >= 0 && y < size.y)) {
            return true;
        }
        return false;
    }

}
