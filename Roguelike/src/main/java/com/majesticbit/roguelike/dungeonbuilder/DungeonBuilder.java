/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.dungeonbuilder;

import com.majesticbit.roguelike.domain.dungeon.BasicDungeon;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Master
 */
public class DungeonBuilder {

    private Dungeon dungeon;
    private List<Element> elements;
    private Settings settings;

    public DungeonBuilder() {
        this(Settings.DEFAULT_SETTINGS);
    }

    public DungeonBuilder(Settings settings) {
        this.settings = settings;
        elements = new ArrayList();
        dungeon = new BasicDungeon(settings.getWidth(), settings.getHeight());
        RoomGenerator generator = new DefaultRoomGenerator();
        elements.addAll(generator.generate(settings));
        generateTiles();
    }

    public Dungeon toDungeon() {
        return dungeon;
    }

    private void generateTiles() {
        for (int x = 0; x < settings.getWidth(); x++) {
            for (int y = 0; y < settings.getHeight(); y++) {
                for (Element element : elements) {
                    if (element.isWall(x, y)) {
                        dungeon.getTile(x, y).buildWall();
                    }
                }
                for (Element element : elements) {
                    if (element.isOpen(x, y)) {
                        dungeon.getTile(x, y).buildOpening();
                    }
                }
            }
        }
    }

}
