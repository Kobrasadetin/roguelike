/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures.actions;

import com.majesticbit.roguelike.domain.creatures.Creature;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public abstract class Action {

    /**
     *
     */
    public static final Action NONE = new Wait();

    /**
     * MOVE has direction NONE - it can be used to check if an action is of type
     * Move
     */
    public static final Action MOVE = new Move();

    /**
     * QUIT is an UI command to quit the game
     *
     */
    public static final Action QUIT = new GameCommand("quit");

    /**
     *
     * @param direction
     * @return
     */
    public static final Action move(Direction direction) {
        return new Move(direction);
    }

    /**
     *
     */
    public Action() {
    }

    /**
     *
     * @param creature
     * @return
     */
    public abstract int calculateTimeUntilComplete(Creature creature);

    /**
     *
     * @param creature
     */
    public void execute(Creature creature) {
    }

    /**
     * Can be used to check if a creature is currently engaged in a certain type
     * of action. Default implementation compares the classes.
     *
     * @param action
     * @return true if action is the same type as action
     */
    public boolean isOfType(Action action) {
        if (getClass() != action.getClass()) {
            return false;
        }
        return true;
    }

}
