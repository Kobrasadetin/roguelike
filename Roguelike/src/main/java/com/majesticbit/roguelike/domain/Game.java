/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.gui.UserInterface;
import com.majesticbit.roguelike.dungeonbuilder.DungeonBuilder;

/**
 *
 * @author Master
 */
public class Game {

    private BasicLevel currentLevel;
    private Player player;

    public Game(UserInterface ui) {
        Dungeon dungeon = new DungeonBuilder().toDungeon();
        currentLevel = new BasicLevel(dungeon);
        player = new Player(ui);
        Humanoid playerCreature = new Humanoid(new Position(4, 4), new TextDescription("player", '@'), player);
        currentLevel.addCreature(playerCreature, playerCreature.getPosition());
    }

    public BasicLevel getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(BasicLevel level) {
        this.currentLevel = level;
    }

    public Player getPlayer() {
        return player;
    }

    public void play() {
        player.bestowKnowledge(currentLevel);
        
    }

}
