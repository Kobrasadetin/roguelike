/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.creatures.PlayerController;
import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.level.BasicLevel;
import com.majesticbit.roguelike.domain.creatures.Humanoid;
import com.majesticbit.roguelike.domain.creatures.RandomAIController;
import com.majesticbit.roguelike.domain.creatures.actions.Action;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.fov.VisibilitySolver;
import com.majesticbit.roguelike.gui.UserInterface;
import com.majesticbit.roguelike.dungeonbuilder.DungeonBuilder;

/**
 *
 * @author Master
 */
public class Game implements Observable, GameEventListener {

    private BasicLevel currentLevel;
    private PlayerController player;
    private VisibilitySolver visibilitySolver;
    private boolean waitingPlayer;
    private boolean playerQuit;
    private GameInterface gameInterface;

    public Game() {
        this.player = new PlayerController(this);
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void play() {
        currentLevel = createNewLevel();
        currentLevel.addMessageListener(this);
        createPlayterAvatar();
        createTestMonsters();
        createTestPassive();
        while (!playerQuit) {
            currentLevel.advanceOneTimestep();
        }
        //player.bestowFullKnowledge(currentLevel);
    }

    private BasicLevel createNewLevel() {
        Dungeon dungeon = new DungeonBuilder().toDungeon();
        BasicLevel newLevel = new BasicLevel(dungeon);
        return newLevel;
    }

    private void advanceOneTimestep() {
        currentLevel.advanceOneTimestep();
    }

    private void createPlayterAvatar() {
        Humanoid playerCreature = new Humanoid(new Position(4, 4), new TextDescription("player", '@'));
        playerCreature.setController(player);
        currentLevel.addCreature(playerCreature, playerCreature.getPosition());
    }

    private void createTestMonsters() {
        Humanoid monster = new Humanoid(new Position(4, 12), new TextDescription("an orc", 'O'), new RandomAIController());
        Humanoid monster2 = new Humanoid(new Position(24, 12), new TextDescription("a snake", 's'), new RandomAIController());
        currentLevel.addCreature(monster);
        currentLevel.addCreature(monster2);
    }

    private void createTestPassive() {
        Humanoid monster = new Humanoid(new Position(5, 8), new TextDescription("a boulder", '*'));
        currentLevel.addCreature(monster);
    }

    public Action getPlayerAction() {
        return gameInterface.getPlayerAction(player.getKnownLevel());
    }

    @Override
    public void addObserver(GameInterface newGameInterface) {
        this.gameInterface = newGameInterface;
    }

    public void broadcastMessage(String message) {
        gameInterface.showMessage(message);
    }

    @Override
    public void processGameEvent(GameEvent event) {
        if (event.printsMessage()) {
            gameInterface.showMessage(event.getMessage());
        }
    }

}
