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
public interface Tile {
    public String getDescription();
    public boolean isSolid();
    public boolean isWall();

    public boolean buildOpening();
    public boolean buildWall();
    
    public static Tile OUT_OF_BOUNDS = new OUT_OF_BOUNDS();
        
    // OUT_OF_BOUNDS is the default tile for tiles outside our map
    public static class OUT_OF_BOUNDS implements Tile
    {
        @Override
        public String getDescription()
        {
            return "impenetrable rock";
        }

        @Override
        public boolean isSolid() {
            return true;
        }

        @Override
        public boolean buildWall() {
            throw new UnsupportedOperationException("Building walls outside game area.");
        }

        @Override
        public boolean isWall() {
            return true;
        }

        @Override
        public boolean buildOpening() {
            return false;
        }
    }
}
