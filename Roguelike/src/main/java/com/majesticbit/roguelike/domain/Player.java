/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.gui.UserInterface;

/**
 *
 * @author Master
 */
public class Player implements CreatureController {

    private UserInterface userInterface;
    private EpistemeLevel knownLevel;

    public Player(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public void bestowKnowledge(BasicLevel level) {
        knownLevel = new EpistemeLevel(level);
        userInterface.drawAscii(knownLevel);
    }

}
