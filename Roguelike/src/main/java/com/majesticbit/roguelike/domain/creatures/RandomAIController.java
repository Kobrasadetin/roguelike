/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures;

import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.creatures.CreatureController;
import com.majesticbit.roguelike.domain.creatures.actions.Action;
import java.util.Random;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public class RandomAIController implements CreatureController {

    private Creature creature;

    //TODO:implementation
    @Override
    public void initializeKnowledge(Creature creature, Level level) {
        this.creature = creature;
    }

    @Override
    public void bestowPartialKnowledge(Level level, float[][] map) {

    }

    @Override
    public boolean wantsToMakeNewDecisions() {

        return true;
    }

    private Action selectRandomAction() {
        int actionNumber = (new Random()).nextInt(Direction.values().length);
        return Action.move(Direction.values()[actionNumber]);
    }

    @Override
    public void decideAction() {
        if (creature.currentActionIsType(Action.NONE)) {
            Action newAction = selectRandomAction();
            creature.changeAction(newAction);
        }
    }

}
