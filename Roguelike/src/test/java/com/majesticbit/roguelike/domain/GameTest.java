/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.creatures.PlayerController;
import com.majesticbit.roguelike.domain.creatures.actions.Action;
import com.majesticbit.roguelike.domain.level.Level;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Master
 */
public class GameTest {

    Game instance;
    GameInterfaceImpl interfaceImpl;

    public GameTest() {
    }

    @Before
    public void setUp() {
        instance = new Game();
        interfaceImpl = new GameInterfaceImpl();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentLevel method, of class Game.
     */
    @Test
    public void testGetCurrentLevel() {
        Level expResult = null;
        Level result = instance.getCurrentLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayer method, of class Game.
     */
    @Test
    public void testGetPlayer() {
        Game instance = new Game();
        PlayerController result = instance.getPlayer();
        assertTrue(result != null);
    }

    /**
     * Test of getPlayerAction method, of class Game.
     */
    @Test
    public void testGetPlayerAction() {
        Action expResult = Action.NONE;
        instance.addObserver(interfaceImpl);
        Action result = instance.getPlayerAction();
        assertEquals(expResult, result);
    }

    /**
     * Test of addObserver method, of class Game.
     */
    @Test
    public void testAddObserver() {
        instance.addObserver(interfaceImpl);
        instance.getPlayerAction();
        assertTrue(interfaceImpl.wasInteracted());

    }

    /**
     * Test of broadcastMessage method, of class Game.
     */
    @Test
    public void testBroadcastMessage() {
        instance.addObserver(interfaceImpl);
        String message = "hello";
        instance.broadcastMessage(message);
        assertTrue(interfaceImpl.getMessage().equals("hello"));
    }

    //TODO:Test of processGameEvent method, of class Game.
    private static class GameInterfaceImpl implements GameInterface {

        private String message;

        public String getMessage() {
            return message;
        }
        private boolean wasInteracted = false;

        public boolean wasInteracted() {
            return wasInteracted;
        }

        public GameInterfaceImpl() {
        }

        @Override
        public Action getPlayerAction(Level level) {
            wasInteracted = true;
            return Action.NONE;
        }

        @Override
        public void showMessage(String message) {
            wasInteracted = true;
            this.message = message;
        }
    }

}
