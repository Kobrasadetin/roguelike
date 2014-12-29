package com.majesticbit.roguelike.domain.dungeon;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Master
 */
public interface Dungeon extends GeometryChangeEmitter {

    /**
     *
     * @return width in tiles
     */
    public int getWidth();

    /**
     *
     * @return height in tiles
     */
    public int getHeight();

    /**
     *
     * @param x horizontal position
     * @param y vertical position
     * @return return tile in position x,y
     */
    public Tile getTile(int x, int y);

    /**
     *
     * @param x horizontal position
     * @param y vertical position
     * @param tile new tile in the position x,y
     * @return true if the tile was set
     */
    public boolean setTile(int x, int y, Tile tile);

}
