/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

/**
 *
 * @author Master
 */
public class BasicTile implements Tile {
    
    private boolean solid;
    private boolean wall;
    
    public BasicTile()
    {
        solid = true;
        wall = false;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }

    @Override
    public String getDescription() {
        return ("a basic tile");
    }

    @Override
    public boolean isSolid() {
        return solid;
    }
    
    @Override
    public boolean buildWall() {
        wall = true;
        return true;
    }

    @Override
    public boolean isWall() {
        return wall;
    }

    @Override
    public boolean buildOpening() {
        wall = false;
        solid = false;
        return true;
    }

}
