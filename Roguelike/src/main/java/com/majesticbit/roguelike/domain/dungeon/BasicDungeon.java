/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.dungeon;

import com.majesticbit.roguelike.domain.GeometryChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Master
 */
public class BasicDungeon implements Dungeon, GeometryChangeListener {

    private int width;
    private int height;
    private Tile[][] tiles;
    List<GeometryChangeListener> listeners;

    public BasicDungeon(int width, int height) {
        this.width = width;
        this.height = height;
        listeners = new ArrayList();
        generateTiles();
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean setTile(int x, int y, Tile tile) {
        if (isInBounds(x, y)) {
            tiles[x][y] = tile;
            return true;
        }
        return false;
    }

    @Override
    public Tile getTile(int x, int y) {
        if (isInBounds(x, y)) {
            return tiles[x][y];
        }
        return Tile.OUT_OF_BOUNDS;
    }

    private void generateTiles() {
        tiles = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = new BasicTile();
            }
        }
    }

    private boolean isInBounds(int x, int y) {
        if ((x >= 0 && x < width) && (y >= 0 && y < height)) {
            return true;
        }
        return false;
    }
    

    @Override
    public void geometryChanged() {
        for (GeometryChangeListener hl : listeners) {
            hl.geometryChanged();
        }
    }

    @Override
    public void addGeometryChangeListener(GeometryChangeListener toAdd) {
        listeners.add(toAdd);
    }
}
