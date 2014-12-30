/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures.actions;

import com.majesticbit.roguelike.domain.creatures.Creature;

/**
 *
 * @author Master
 */
public class CreatureAction {

    private int timeUntilComplete;
    private Creature myCreature;
    private Action action;

    public Action getAction() {
        return action;
    }

    public int getTimeUntilComplete() {
        return timeUntilComplete;
    }

    public CreatureAction(Creature myCreature) {
        this.myCreature = myCreature;
        this.action = Action.NONE;
    }

    public void setAction(Action action) {
        this.action = action;
        this.timeUntilComplete = action.calculateTimeUntilComplete(myCreature);
    }

    public boolean isReadyToExecute() {
        return timeUntilComplete == 0;
    }

    public void execute() {
        this.action.execute(myCreature);
        this.action = Action.NONE;
    }

    public void advanceTimestep() {
        if (timeUntilComplete > 0) {
            timeUntilComplete--;
        }
    }

}
