/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.Game;
import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.domain.creatures.actions.Action;
import com.majesticbit.roguelike.domain.level.Level;

/**
 *
 * @author Master
 */
public class UserInterface {

    private VisualInterface visualInterface;
    private PlayerInput input;
    private boolean quitGame = false;

    public UserInterface() {
        this.visualInterface = new AsciiViewer();
        this.input = new SystemInput();
    }

    public void draw(Level level) {
        visualInterface.draw(level);
    }

    public Action getPlayerAction(Creature creature) {
        Action playerAction = input.getAction(creature);
        if (checkForGameCommands(playerAction))
        {
            return Action.NONE;
        }
        return playerAction;
    }

    public boolean playerWantsToQuit() {
        return quitGame;
    }

    private boolean checkForGameCommands(Action playerAction) {
        if (playerAction.equals(Action.QUIT)) {
            quitGame = true;
            return true;
        }
        return false;
    }

}
