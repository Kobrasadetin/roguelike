/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures;

import com.majesticbit.roguelike.domain.Game;
import com.majesticbit.roguelike.domain.level.EpistemeLevel;
import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.creatures.CreatureController;
import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.domain.creatures.actions.Action;
import com.majesticbit.roguelike.domain.creatures.actions.Move;
import com.majesticbit.roguelike.gui.UserInterface;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public class PlayerController implements CreatureController {

    private Game game;
    private EpistemeLevel knownLevel;
    private Creature avatar;

    public Creature getAvatar() {
        return avatar;
    }

    public PlayerController(Game game) {
        this.game = game;
    }

    @Override
    public void initializeKnowledge(Creature avatar, Level level) {
        this.avatar = avatar;
        knownLevel = new EpistemeLevel(level);
    }

    @Override
    public void bestowPartialKnowledge(Level level, float[][] map) {
        if (level == knownLevel.getLevel()) {
            knownLevel.addKnowledge(map);
        }
    }

    public void bestowFullKnowledge(Level level) {
        if (level == knownLevel.getLevel()) {
            knownLevel.addFullKnowledge();
        }
    }

    public Level getKnownLevel() {
        return knownLevel;
    }

    @Override
    public boolean wantsToMakeNewDecisions() {
        return true;
    }

    @Override
    public void decideAction() {
        if (avatar.currentActionIsType(Action.NONE)) {
            avatar.changeAction(game.getPlayerAction());
        }
    }

}
