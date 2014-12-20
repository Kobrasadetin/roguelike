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

    /** Returns textual description of the tile
     *
     * @return String containing description of the tile
     */
    public String getDescription();

    /**
     *
     * @return true if solid (cannot be moved trough, blocks sight)
     */
    public boolean isSolid();
    public boolean isWall();

    /** unset solid, unset wall
     *
     * @return true if successful
     */
    public boolean buildOpening();

    /** set wall, set solid
     *
     * @return true if successful
     */
    public boolean buildWall();
    
    /** OUT_OF_BOUNDS is the default tile returned for all positions outside the game area
     *
     */
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
