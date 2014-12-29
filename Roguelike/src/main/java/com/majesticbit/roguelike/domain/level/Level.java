/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.level;

import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import java.util.List;

/**
 * Levels have a dungeon and DynmamicObjects
 *
 * @author Master
 */
public interface Level {

    /**
     *
     * @return List of all DynamicObjects in the level
     */
    public List<DynamicObject> getObjects();

    /**
     *
     * @return the dungeon the level consists of
     */
    public Dungeon getDungeon();
}
