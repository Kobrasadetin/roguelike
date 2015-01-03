/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.level;

import com.majesticbit.roguelike.domain.dungeon.ChangeEventListener;
import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.simulation.DynamicObject;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.dungeon.EpistemeDungeon;
import com.majesticbit.roguelike.domain.fov.VisibilitySolver;
import java.util.List;

/**
 *
 * @author Master
 */
public class EpistemeLevel implements LevelKnowledge, ChangeEventListener {

    private EpistemeDungeon knownDungeon;
    private Level level;

    public Level getLevel() {
        return level;
    }

    public EpistemeLevel(Level level) {
        this.level = level;
        knownDungeon = new EpistemeDungeon(level.getDungeon());
    }

    @Override
    public List<DynamicObject> getObjects() {
        return level.getObjects();
    }

    @Override
    public Dungeon getDungeon() {
        return knownDungeon;
    }

    public void addKnowledge(float[][] map) {
        knownDungeon.revealUsingFloatMask(map, 0.1f);
    }

    public void addFullKnowledge() {
        knownDungeon.revealAllTiles();
    }

    @Override
    public VisibilitySolver getVisibilitySolver() {
        return this.level.getVisibilitySolver();
    }

    @Override
    public void somethingHasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
