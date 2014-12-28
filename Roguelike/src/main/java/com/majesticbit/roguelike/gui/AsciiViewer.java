/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.DynamicObject;
import com.majesticbit.roguelike.domain.BasicLevel;
import com.majesticbit.roguelike.domain.Level;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.dungeon.Tile;

/**
 *
 * @author Master
 */
public class AsciiViewer extends VisualInterface {

    private int width, height;
    private String baseString;

    public AsciiViewer(Level level) {
        this.width = level.getDungeon().getWidth();
        this.height = level.getDungeon().getHeight();
        super.setLevel(level);
        initialize();
    }

    @Override
    public void draw() {
        // fist, draw tiles
        Level level = super.level;
        width = level.getDungeon().getWidth();
        this.height = level.getDungeon().getHeight();
        Dungeon dungeon = level.getDungeon();
        StringBuilder[] line = new StringBuilder[height];
        for (int y = 0; y < height; y++) {
            line[y] = new StringBuilder(baseString);
            for (int x = 0; x < width; x++) {
                Tile tile = dungeon.getTile(x, y);
                line[y].setCharAt(x, tile.getDescription().getSymbol());
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

    private void initialize() {
        StringBuilder dottedRow = new StringBuilder();
        for (int x = 0; x < width; x += 8) {
            dottedRow.append("........");
        }
        dottedRow.setLength(width);
        baseString = dottedRow.toString();
    }

}
