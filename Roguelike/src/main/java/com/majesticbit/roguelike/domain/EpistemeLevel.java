/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.dungeon.EpistemeDungeon;
import java.util.List;

/**
 *
 * @author Master
 */
public class EpistemeLevel implements Level {

    private EpistemeDungeon knownDungeon;
    private BasicLevel level;

    public EpistemeLevel(BasicLevel level) {
        this.level = level;
        knownDungeon = new EpistemeDungeon(level.getDungeon());
        knownDungeon.revealAllTiles();
    }

    @Override
    public List<DynamicObject> getObjects() {
        return level.getObjects();
    }

    @Override
    public Dungeon getDungeon() {
        return knownDungeon;
    }

}
