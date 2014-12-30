/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.creatures.actions.Action;
import com.majesticbit.roguelike.domain.level.Level;

/**
 *
 * @author Master
 */
public class UserInterface {

    private VisualInterface visualInterface;
    private PlayerInput input;

    public UserInterface() {
        visualInterface = new AsciiViewer();
        input = new SystemInput();
    }

    public void draw(Level level) {
        visualInterface.draw(level);
    }

    public Action getPlayerAction() {
        return input.getAction();
    }

}
