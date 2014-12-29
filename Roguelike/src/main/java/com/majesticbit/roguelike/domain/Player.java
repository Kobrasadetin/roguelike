/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.level.EpistemeLevel;
import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.creatures.CreatureController;
import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.gui.UserInterface;

/**
 *
 * @author Master
 */
public class Player implements CreatureController {

    private UserInterface userInterface;
    private EpistemeLevel knownLevel;
    private Creature avatar;

    public Creature getAvatar() {
        return avatar;
    }

    public Player(Creature avatar, UserInterface userInterface) {
        this.userInterface = userInterface;
        this.avatar = avatar;
    }

    @Override
    public void initializeKnowledge(Level level) {
        knownLevel = new EpistemeLevel(level);
        userInterface.drawAscii(knownLevel);
    }

    public void bestowPartialKnowledge(Level level, float[][] map) {
        if (level == knownLevel.getLevel()) {
            knownLevel.addKnowledge(map);
        }
        userInterface.drawAscii(knownLevel);
    }

}
