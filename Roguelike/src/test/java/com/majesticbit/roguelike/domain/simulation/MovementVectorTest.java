/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.simulation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public class MovementVectorTest {

    public MovementVectorTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addMovementToDirection method, of class MovementVector.
     */
    @Test
    public void testAddMovementToDirection() {
        Direction[] directions = Direction.values();
        for (Direction dir : directions) {
            MovementVector instance = new MovementVector();
            instance.addMovementToDirection(dir);
            assertEquals(instance.performDisplacement(), dir);
        }
    }

    /**
     * Test of potentiallyMoving method, of class MovementVector.
     */
    @Test
    public void testPotentiallyMoving() {
        MovementVector instance = new MovementVector();
        assertEquals(instance.potentiallyMoving(), false);
        instance.addMovementToDirection(Direction.DOWN);
        assertEquals(instance.potentiallyMoving(), true);
    }

    /**
     * Test of performDisplacement method, of class MovementVector.
     */
    @Test
    public void testPerformDisplacement() {
        MovementVector instance = new MovementVector();
        Direction expResult = Direction.NONE;
        Direction result = instance.performDisplacement();
        assertEquals(expResult, result);
        instance.addMovementToDirection(Direction.UP);
        expResult = Direction.UP;
        result = instance.performDisplacement();
        assertEquals(expResult, result);

    }

    @Test
    public void testPublicVariablesAndMovement() {
        MovementVector instance = new MovementVector();
        assertTrue(instance.x == 0);
        assertTrue(instance.y == 0);
        instance.addMovementToDirection(Direction.UP);
        assertTrue(instance.y == -1);
        instance.addMovementToDirection(Direction.RIGHT);
        assertTrue(instance.x == 1);
        Direction result = instance.performDisplacement();
        assertEquals(Direction.UP_RIGHT, result);
        assertTrue(instance.x == 0);
        assertTrue(instance.y == 0);
    }

}
