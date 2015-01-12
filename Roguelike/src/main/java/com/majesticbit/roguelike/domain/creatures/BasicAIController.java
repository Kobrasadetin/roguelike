/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures;

import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.creatures.CreatureController;

/**
 *
 * @author Master
 */
public class BasicAIController implements CreatureController {

    //TODO:implementation
    @Override
    public void initializeKnowledge(Creature creature, Level level) {

    }

    @Override
    public void bestowPartialKnowledge(Level level, float[][] map) {

    }

    @Override
    public boolean wantsToMakeNewDecisions() {
        return false;
    }

    @Override
    public void decideAction() {
        //TODO
    }

}
