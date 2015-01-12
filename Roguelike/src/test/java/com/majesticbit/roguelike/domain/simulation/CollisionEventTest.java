/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.simulation;

import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.TextDescription;
import com.majesticbit.roguelike.domain.creatures.Humanoid;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Master
 */
public class CollisionEventTest {

    CollisionEvent instance;
    DynamicObject testObject1;
    DynamicObject testObject2;

    public CollisionEventTest() {
    }

    @Before
    public void setUp() {
        testObject1 = new Humanoid(new Position(0, 0), new TextDescription("testObject1", 't'));
        testObject2 = new Humanoid(new Position(0, 0), new TextDescription("testObject2", 't'));
        instance = new CollisionEvent(testObject1, testObject2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of printsMessage method, of class CollisionEvent.
     */
    @Test
    public void testPrintsMessage() {
        boolean expResult = true;
        boolean result = instance.printsMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMessage method, of class CollisionEvent.
     */
    @Test
    public void testGetMessage() {
        String expResult = "testObject1 collided with testObject2\ntestObject2 was pushed!";
        String result = instance.getMessage();
        assertEquals(expResult, result);
    }

}
