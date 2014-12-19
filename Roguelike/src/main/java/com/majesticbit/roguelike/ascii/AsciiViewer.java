/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.ascii;

import com.majesticbit.roguelike.domain.Dungeon;

/**
 *
 * @author Master
 */
public class AsciiViewer {

    private int width, height;
    private String baseString;
    private Dungeon dungeon;

    public AsciiViewer(Dungeon dungeon) {
        this.width = dungeon.getWidth();
        this.height = dungeon.getHeight();
        this.dungeon = dungeon;
        initialize();
    }

    public String draw() {
        StringBuilder output = new StringBuilder();
        StringBuilder line = new StringBuilder(baseString);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (dungeon.getTile(x, y).isSolid()) {
                    line.setCharAt(x, ' ');
                }
                if (dungeon.getTile(x, y).isWall()) {
                    line.setCharAt(x, '#');
                }
                if (!dungeon.getTile(x, y).isSolid()) {
                    line.setCharAt(x, '.');
                }
            }
            output.append(line);
            output.append('\n');
        }
        return output.toString();
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
