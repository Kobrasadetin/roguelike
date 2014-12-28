package com.majesticbit.roguelike.domain.dungeon;

import com.majesticbit.roguelike.domain.Description;
import com.majesticbit.roguelike.domain.EmptyContainer;
import com.majesticbit.roguelike.domain.GeometryChangeEmitter;
import com.majesticbit.roguelike.domain.GeometryChangeListener;
import com.majesticbit.roguelike.domain.ItemContainer;
import com.majesticbit.roguelike.domain.TextDescription;
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
public interface Tile extends GeometryChangeEmitter {

    /**
     *
     *
     * @return ItemContainer of the tile
     */
    public ItemContainer getContainer();

    /**
     * Returns description of the tile
     *
     * @return Description containing description of the tile
     */
    public Description getDescription();

    /**
     *
     * @return true if solid (cannot be moved trough, blocks sight)
     */
    public boolean isSolid();

    public boolean isWall();

    /**
     * unset solid, unset wall
     *
     * @return true if successful
     */
    public boolean buildOpening();

    /**
     * set wall, set solid
     *
     * @return true if successful
     */
    public boolean buildWall();

    /**
     * OUT_OF_BOUNDS is the default tile returned for all positions outside the
     * game area
     *
     */
    public static final Tile OUT_OF_BOUNDS = new OutOfBounds();
    /**
     * UNKNOWN is the default tile returned for all unknown tiles
     *
     */
    public static final Tile UNKNOWN = new Unknown();

    // OUT_OF_BOUNDS is the default tile for tiles outside our map
    public static class OutOfBounds extends StaticTile {

    }

    // UNKNOWN is the default tile for tiles we don't know about
    public static class Unknown extends StaticTile {

        @Override
        public Description getDescription() {
            return new TextDescription("unknown", ' ');
        }

        @Override
        public boolean isSolid() {
            return false;
        }

        @Override
        public boolean isWall() {
            return false;
        }
    }

    public static class StaticTile implements Tile {

        @Override
        public Description getDescription() {
            return new TextDescription("impenetrable rock");
        }

        @Override
        public boolean isSolid() {
            return true;
        }

        @Override
        public boolean buildWall() {
            throw new UnsupportedOperationException("Building walls to a static tile.");
        }

        @Override
        public boolean isWall() {
            return true;
        }

        @Override
        public boolean buildOpening() {
            return false;
        }

        @Override
        public ItemContainer getContainer() {
            return new EmptyContainer();
        }

        @Override
        public void addGeometryChangeListener(GeometryChangeListener toAdd) {
            //The static tile will never change, no need to add listeners.
        }

    }
}
