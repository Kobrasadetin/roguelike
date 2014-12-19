package com.majesticbit.roguelike.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Master
 */
public interface Dungeon {
    public int getWidth();
    public int getHeight();
    public Tile getTile(int x, int y);
    public boolean setTile(int x, int y, Tile tile);
}
