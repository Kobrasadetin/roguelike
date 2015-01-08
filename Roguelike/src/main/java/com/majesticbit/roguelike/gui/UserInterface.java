/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.Game;
import com.majesticbit.roguelike.domain.GameInterface;
import com.majesticbit.roguelike.domain.creatures.actions.Action;
import com.majesticbit.roguelike.domain.level.Level;

/**
 *
 * @author Master
 */
public class UserInterface implements GameInterface{

    private VisualInterface visualInterface;
    private PlayerInput input;
    private Game game;

    public UserInterface(Game game) {
        addSwingViewer();
        this.game = game;
        game.addObserver(this);
    }
    
    private void addSwingViewer()
    {
        SwingViewer viewer = new SwingViewer();
        SwingPlayerInput input =  new SwingPlayerInput(viewer);
        this.visualInterface = viewer;
        this.input = input;
        viewer.addKeyEventListener(input);
    }

    private void draw(Level level) {
        visualInterface.draw(level);
    }

    @Override
    public Action getPlayerAction(Level level) {
        draw(level);
        Action playerAction = input.getAction();
        if (checkForGameCommands(playerAction))
        {
            return Action.NONE;
        }
        return playerAction;
    }

    private boolean checkForGameCommands(Action playerAction) {
        if (playerAction.equals(Action.QUIT)) {
            //TODO: nicer quit
            System.exit(0);
        }
        return false;
    }

    @Override
    public void showMessage(String message) {
        visualInterface.showMessage(message);
    }

}
