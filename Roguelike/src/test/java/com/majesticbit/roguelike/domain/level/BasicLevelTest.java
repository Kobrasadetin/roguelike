/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.level;

import com.majesticbit.roguelike.domain.Description;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.TextDescription;
import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.domain.creatures.CreatureController;
import com.majesticbit.roguelike.domain.creatures.Humanoid;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.fov.VisibilitySolver;
import com.majesticbit.roguelike.domain.simulation.DynamicObject;
import com.majesticbit.roguelike.dungeonbuilder.DungeonBuilder;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.objects.Global.instance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Master
 */
public class BasicLevelTest {

    Dungeon dungeon;
    Creature creature;
    MockupCreature mockupCreature;
    BasicLevel levelInstance;

    public BasicLevelTest() {

    }

    private class MockupCreature extends Humanoid {

        private boolean update = false;

        public MockupCreature(Position position, Description description) {
            super(position, description);
        }

        public boolean wasUpdated() {
            return update;
        }

        @Override
        public void updateKnowledge(Level level) {
            update = true;
        }

    }

    @Before
    public void setUp() {
        dungeon = new DungeonBuilder().toDungeon();
        creature = new Humanoid(new Position(4, 4), new TextDescription("player", '@'));
        mockupCreature = new MockupCreature(new Position(4, 4), new TextDescription("player", '@'));
        levelInstance = new BasicLevel(dungeon);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addCreature method, of class BasicLevel.
     */
    @Test
    public void testAddCreature() {
        System.out.println("addCreature");
        Position position = new Position(4, 4);
        boolean success = levelInstance.addCreature(creature, position);
        List<DynamicObject> objects = levelInstance.getObjects();
        boolean expResult = false;
        assertTrue(success);
        assertEquals(objects.size(), 1);
        assertEquals(objects.get(0), creature);
    }

    /**
     * Test of getVisibilitySolver method, of class BasicLevel.
     */
    @Test
    public void testGetVisibilitySolver() {
        VisibilitySolver result = levelInstance.getVisibilitySolver();
        assertEquals(result.getClass(), VisibilitySolver.class);
    }

    /**
     * Test of getObjects method, of class BasicLevel.
     */
    @Test
    public void testGetObjects() {
        List<DynamicObject> result = levelInstance.getObjects();
        assertTrue(result != null);
        assertTrue(result.isEmpty());
    }

    /**
     * Test of getDungeon method, of class BasicLevel.
     */
    @Test
    public void testGetDungeon() {
        Dungeon expResult = dungeon;
        Dungeon result = levelInstance.getDungeon();
        assertEquals(expResult, result);
    }

    /**
     * Test of dynamicObjects method, of class BasicLevel.
     */
    @Test
    public void testDynamicObjects() {
        List<DynamicObject> result = levelInstance.dynamicObjects();
        assertEquals(result.isEmpty(), true);
    }

    /**
     * Test of getSimulatedDungeon method, of class BasicLevel.
     */
    @Test
    public void testGetSimulatedDungeon() {
        Dungeon expResult = dungeon;
        Dungeon result = levelInstance.getSimulatedDungeon();
        assertEquals(expResult, result);
    }

    /**
     * Test of dynamicCreatures method, of class BasicLevel.
     */
    @Test
    public void testDynamicCreatures() {
        System.out.println("dynamicCreatures");

        List<Creature> expResult = new ArrayList();
        expResult.add(creature);
        levelInstance.addCreature(creature, creature.getPosition());
        List<Creature> result = levelInstance.dynamicCreatures();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateCreatures method, of class BasicLevel.
     */
    @Test
    public void testUpdateCreatures() {
        levelInstance.addCreature(mockupCreature, mockupCreature.getPosition());
        assertFalse(mockupCreature.wasUpdated());
        levelInstance.updateCreatures();
        assertTrue(mockupCreature.wasUpdated());

    }

}
