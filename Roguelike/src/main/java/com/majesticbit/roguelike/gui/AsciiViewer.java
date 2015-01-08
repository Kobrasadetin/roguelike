/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.simulation.DynamicObject;
import com.majesticbit.roguelike.domain.level.BasicLevel;
import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.dungeon.Tile;

/**
 *
 * @author Master
 */
public class AsciiViewer extends VisualInterface {

    private int width, height;

    public AsciiViewer() {
    }

    @Override
    public void draw(Level level) {
        // fist, draw tiles
        width = level.getDungeon().getWidth();
        height = level.getDungeon().getHeight();
        Dungeon dungeon = level.getDungeon();
        StringBuilder[] line = new StringBuilder[height];
        for (int y = 0; y < height; y++) {
            line[y] = new StringBuilder(width);
            for (int x = 0; x < width; x++) {
                Tile tile = dungeon.getTile(x, y);
                line[y].append(tile.getDescription().getSymbol());
            }
        }

        // draw creatures and other dynamic objects
        for (DynamicObject object : level.getObjects()) {
            Position pos = object.getPosition();
            line[pos.y].setCharAt(pos.x, object.getDescription().getSymbol());
        }

        // output graphics
        StringBuilder output = new StringBuilder();
        for (int y = 0; y < height; y++) {
            output.append(line[y]);
            output.append('\n');
        }

        System.out.println(output.toString());
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

}
