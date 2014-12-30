/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.dungeon.Tile;
import com.majesticbit.roguelike.domain.simulation.DynamicObject;
import com.majesticbit.roguelike.domain.level.Level;
import java.awt.Font;
import squidpony.squidgrid.gui.SGPane;
import squidpony.squidgrid.gui.swing.SwingPane;

/**
 *
 * @author Master
 */
public class SwingViewer extends VisualInterface {

    private int width, height;
    private SGPane pane;

    public SwingViewer() {
        pane = new SwingPane();
        pane.initialize(30, 20, new Font("TimesRoman", Font.PLAIN, 18));
    }

    @Override
    public void draw(Level level) {
        pane.placeText(0, 0, characterMap(level));

    }

    public static char[][] characterMap(Level level) {

        Dungeon dungeon = level.getDungeon();
        int width = dungeon.getWidth();
        int height = dungeon.getHeight();
        char[][] map = new char[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Tile tile = dungeon.getTile(x, y);
                map[x][y] = tile.getDescription().getSymbol();
            }
        }

        // draw creatures and other dynamic objects
        for (DynamicObject object : level.getObjects()) {
            Position pos = object.getPosition();
            map[pos.x][pos.y] = object.getDescription().getSymbol();
        }

        return map;
    }

}
