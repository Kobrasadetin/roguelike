/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures.actions;

import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.TextDescription;
import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.domain.creatures.Humanoid;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public class ActionTest {

    private Creature testCreature;

    public ActionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testCreature = new Humanoid(new Position(4, 4), new TextDescription("testCreature", '@'));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isOfType method, of class Action.
     */
    @Test
    public void testIsOfTypeUntrue() {
        System.out.println("isOfType untrue 1");
        Action action = Action.MOVE;
        Action instance = new ActionImpl();
        boolean expResult = false;
        boolean result = instance.isOfType(action);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsOfTypeUntrueForStaticObjects() {
        System.out.println("isOfType untrue 2");
        Action action = Action.MOVE;
        Action instance2 = Action.NONE;
        boolean expResult = false;
        boolean result = instance2.isOfType(action);
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveIsOfTypeMove() {
        System.out.println("move(direction) isOfType MOVE");
        Direction direction = Direction.DOWN;
        boolean expResult = true;
        boolean result = Action.move(direction).isOfType(Action.MOVE);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateTimeUntilComplete method, of class Action.
     */
    @Test
    public void testCalculateTimeUntilComplete() {
        System.out.println("calculateTimeUntilComplete");
        Action instance = new ActionImpl();
        int expResult = 0;
        int result = instance.calculateTimeUntilComplete(testCreature);
        assertEquals(expResult, result);
    }

    public class ActionImpl extends Action {

        public int calculateTimeUntilComplete(Creature creature) {
            return 0;
        }
    }

}
