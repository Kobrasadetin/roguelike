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
public class MoveTest {

    Creature testCreature;

    public MoveTest() {
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
     * Test of calculateTimeUntilComplete method, of class Move.
     */
    @Test
    public void testCalculateTimeUntilComplete() {
        System.out.println("calculateTimeUntilComplete");
        Creature creature = testCreature;
        Move instance = new Move(Direction.DOWN);
        int expResult = testCreature.getProperties().getMovementDelay();
        int result = instance.calculateTimeUntilComplete(creature);
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class Move.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Creature creature = testCreature;
        Move instance = new Move();
        instance.execute(creature);
        // TODO review the generated test code and remove the default call to fail.
    }

}
