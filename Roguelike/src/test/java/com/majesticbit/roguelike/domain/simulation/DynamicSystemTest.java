/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.simulation;

import com.majesticbit.roguelike.domain.Description;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.TextDescription;
import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.domain.creatures.CreatureController;
import com.majesticbit.roguelike.domain.creatures.Humanoid;
import com.majesticbit.roguelike.domain.dungeon.ChangeEventListener;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.level.BasicLevel;
import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.dungeonbuilder.DungeonBuilder;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Master
 */
public class DynamicSystemTest {

    DynamicSystem instance;
    BasicLevel theBasicLevel;
    TestCreature creature;
    TestCreature creature2;
    Dungeon dungeon;
    List<DynamicObject> objects;
    List<Creature> creatures;

    public DynamicSystemTest() {
    }

    @Before
    public void setUp() {
        dungeon = new DungeonBuilder().toDungeon();
        creature = new TestCreature(new Position(4, 4), new TextDescription("player", '@'));
        creature2 = new TestCreature(new Position(5, 4), new TextDescription("player", '@'));
        theBasicLevel = new BasicLevel(dungeon);
        instance = theBasicLevel;
        objects = new ArrayList();
        creatures = new ArrayList();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getSimulatedDungeon method, of class DynamicSystem.
     */
    @Test
    public void testGetSimulatedDungeon() {
        Dungeon expResult = dungeon;
        Dungeon result = instance.getSimulatedDungeon();
        assertEquals(expResult, result);
    }

    /**
     * Test of dynamicObjects method, of class DynamicSystem.
     */
    @Test
    public void testDynamicObjects() {
        List<DynamicObject> expResult = objects;
        List<DynamicObject> result = instance.dynamicObjects();
        assertEquals(expResult, result);

        theBasicLevel.addCreature(creature);
        objects.add(creature);

        expResult = objects;
        result = instance.dynamicObjects();
        assertEquals(expResult, result);

    }

    /**
     * Test of dynamicCreatures method, of class DynamicSystem.
     */
    @Test
    public void testDynamicCreatures() {
        List<Creature> expResult = creatures;
        List<Creature> result = instance.dynamicCreatures();
        assertEquals(expResult, result);

        theBasicLevel.addCreature(creature);
        theBasicLevel.addCreature(creature2);
        creatures.add(creature);
        creatures.add(creature2);

        expResult = creatures;
        result = instance.dynamicCreatures();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateCreatures method, of class DynamicSystem.
     */
    @Test
    public void testUpdateCreatures() {
        theBasicLevel.addCreature(creature);
        theBasicLevel.addCreature(creature2);
        instance.updateCreatures();
        assertTrue(creature.wasUpdated());
        assertTrue(creature2.wasUpdated());
    }

    /**
     * Test of getCurrentTime method, of class DynamicSystem.
     */
    @Test
    public void testGetCurrentTime() {
        int expResult = 0;
        int result = instance.getCurrentTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of advanceOneTimestep method, of class DynamicSystem.
     */
    @Test
    public void testAdvanceOneTimestep() {
        instance.advanceOneTimestep();
        assertEquals(instance.getCurrentTime(), 1);
    }

    //TODO: test chance event listeners
    //
    public class DynamicSystemImpl extends DynamicSystem {

        public Dungeon getSimulatedDungeon() {
            return null;
        }

        public List<DynamicObject> dynamicObjects() {
            return null;
        }

        public List<Creature> dynamicCreatures() {
            return null;
        }

        public void updateCreatures() {
        }
    }

    private class TestCreature extends Humanoid {

        public TestCreature(Position position, Description description) {
            super(position, description);
        }

        private boolean update = false;

        public boolean wasUpdated() {
            return update;
        }

        @Override
        public void updateKnowledge(Level level) {
            update = true;
        }

    }

}
