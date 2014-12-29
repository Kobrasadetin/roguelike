/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.dungeon;

import com.majesticbit.roguelike.domain.Description;
import com.majesticbit.roguelike.domain.items.ItemContainer;
import com.majesticbit.roguelike.domain.TextDescription;
import com.majesticbit.roguelike.domain.items.TileContainer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Master
 */
public class BasicTile implements Tile, GeometryChangeEmitter {

    private boolean solid;
    private boolean wall;
    private ItemContainer container;
    private List<GeometryChangeListener> listeners;

    public BasicTile() {
        solid = true;
        wall = false;
        container = new TileContainer();
        listeners = new ArrayList();
    }

    public void setSolid(boolean solid) {
        if (solid != this.solid) {
            this.solid = solid;
            geometryChange();
        }
    }

    @Override
    public Description getDescription() {
        return TileDescription.BasicDescribtion(this);
    }

    @Override
    public boolean isSolid() {
        return solid;
    }

    @Override
    public boolean buildWall() {
        wall = true;
        geometryChange();
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
        geometryChange();
        return true;
    }

    private void geometryChange() {
        for (GeometryChangeListener hl : listeners) {
            hl.geometryChanged();
        }
    }

    @Override
    public ItemContainer getContainer() {
        return container;
    }

    @Override
    public void addGeometryChangeListener(GeometryChangeListener toAdd) {
        listeners.add(toAdd);
    }

}
