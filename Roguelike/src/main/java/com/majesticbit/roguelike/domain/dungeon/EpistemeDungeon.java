/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.dungeon;

import com.majesticbit.roguelike.domain.GeometryChangeListener;

/**
 *
 * @author Master
 */
public class EpistemeDungeon implements Dungeon {

    private boolean[][] knowledge;

    private Dungeon dungeon;

    public EpistemeDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
        knowledge = new boolean[dungeon.getWidth()][dungeon.getHeight()];
    }

    @Override
    public int getWidth() {
        return dungeon.getWidth();
    }

    @Override
    public int getHeight() {
        return dungeon.getHeight();
    }

    @Override
    public Tile getTile(int x, int y) {

        if (isKnown(x, y)) {
            return dungeon.getTile(x, y);
        } else {
            return unknownTile();
        }
    }

    public void revealAllTiles() {
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                knowledge[x][y] = true;
            }
        }
    }

    @Override
    public boolean setTile(int x, int y, Tile tile) {
        //Adding 'false' information about a dungeon might be implemented by another class. EpistemeDungeon only holds
        //justified true beliefs about a dungeon.
        throw new UnsupportedOperationException("Not supported. (setTile in EpistemeDungeon)");
    }

    @Override
    public void addGeometryChangeListener(GeometryChangeListener toAdd) {
        dungeon.addGeometryChangeListener(toAdd);
    }

    private static Tile unknownTile() {
        return Tile.UNKNOWN;
    }

    private boolean isInBounds(int x, int y) {
        if ((x >= 0 && x < dungeon.getWidth()) && (y >= 0 && y < dungeon.getHeight())) {
            return true;
        }
        return false;
    }

    //isKnown returns true if tile is out of bounds
    private boolean isKnown(int x, int y) {
        if (isInBounds(x, y)) {
            return knowledge[x][y];
        }
        return true;
    }
}
