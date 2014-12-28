/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import java.util.List;

/**
 *
 * @author Master
 */
public interface Level {

    public List<DynamicObject> getObjects();

    public Dungeon getDungeon();
}
