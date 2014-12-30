/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures;

import com.majesticbit.roguelike.domain.level.Level;

/**
 *
 * @author Master
 */
public interface CreatureController {

    /**
     * This method is called when the creature enters a new level (or is
     * created).
     *
     * @param creature the controlled creature
     * @param level the new level the creature is in
     */
    public void initializeKnowledge(Creature creature, Level level);

    /**
     * This method should be called when the creature gets new information about
     * a level.
     *
     * @param level is the actual level the creature is in
     * @param map floating point map that contains positive float values for
     * detected tiles (0 to 1, default threshold 0.1)
     */
    public void bestowPartialKnowledge(Level level, float[][] map);
    
    public boolean wantsToMakeNewDecisions();
    
    public void decideAction();

}
