/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.level.BasicLevel;
import com.majesticbit.roguelike.domain.creatures.Humanoid;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.fov.VisibilitySolver;
import com.majesticbit.roguelike.gui.UserInterface;
import com.majesticbit.roguelike.dungeonbuilder.DungeonBuilder;

/**
 *
 * @author Master
 */
public class Game {

    private BasicLevel currentLevel;
    private Player player;
    private VisibilitySolver visibilitySolver;
    private int currentTime = 0;
    private UserInterface ui;

    public Game(UserInterface ui) {
        this.ui = ui;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public Player getPlayer() {
        return player;
    }

    public void play() {
        currentLevel = createNewLevel();
        visibilitySolver = new VisibilitySolver(currentLevel);
        Humanoid playerCreature = new Humanoid(new Position(4, 4), new TextDescription("player", '@'));
        player = new Player(playerCreature, ui);
        currentLevel.addCreature(playerCreature, playerCreature.getPosition());
        player.initializeKnowledge(currentLevel);
        player.bestowPartialKnowledge(currentLevel, visibilitySolver.calculateVisibility(player.getAvatar().getPosition()));

    }

    private BasicLevel createNewLevel() {
        Dungeon dungeon = new DungeonBuilder().toDungeon();
        BasicLevel newLevel = new BasicLevel(dungeon);
        return newLevel;
    }

}
