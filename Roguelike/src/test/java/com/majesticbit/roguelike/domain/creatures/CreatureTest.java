/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures;

import com.majesticbit.roguelike.domain.Description;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.TextDescription;
import com.majesticbit.roguelike.domain.creatures.actions.Action;
import com.majesticbit.roguelike.domain.creatures.actions.CreatureAction;
import com.majesticbit.roguelike.domain.creatures.actions.Move;
import com.majesticbit.roguelike.domain.level.BasicLevel;
import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.simulation.MovementVector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public class CreatureTest {

    Position position;
    CreatureController creatureController;
    Creature instance;
    MockupAction action;
    Description descrb;

    public CreatureTest() {
    }

    @Before
    public void setUp() {
        position = new Position(3, 3);
        creatureController = new BasicAIController();
        descrb = new TextDescription("CreatureImpl", 'c');
        action = new MockupAction();
        instance = new CreatureImpl(position, descrb, creatureController);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMovementVector method, of class Creature.
     */
    @Test
    public void testGetMovementVector() {
        MovementVector result = instance.getMovementVector();
        assertTrue(result != null);
        assertEquals(result.potentiallyMoving(), false);
    }

    /**
     * Test of getCurrentAction method, of class Creature.
     */
    @Test
    public void testGetCurrentAction() {
        Action expResult = Action.NONE;
        Action result = instance.getCurrentAction().getAction();
        assertEquals(expResult, result);

    }

    /**
     * Test of currentActionIsType method, of class Creature.
     */
    @Test
    public void testCurrentActionIsType() {
        Action action = Action.MOVE;
        boolean expResult = false;
        boolean result = instance.currentActionIsType(action);

        assertEquals(expResult, result);

        action = Action.NONE;
        result = instance.currentActionIsType(action);
        expResult = true;
        assertEquals(expResult, result);

    }

    /**
     * Test of executeActionIfReady method, of class Creature.
     */
    @Test
    public void testExecuteActionIfReady() {
        instance.changeAction(action);
        assertFalse(action.wasExecuted());
        instance.executeActionIfReady();
        assertTrue(action.wasExecuted());
    }

    //Test of makeDecisions method, of class Creature. TODO: implement
    /**
     * Test of getProperties method, of class Creature.
     */
    @Test
    public void testGetProperties() {
        Properties result = instance.getProperties();
        assertTrue(result != null);
    }

    /**
     * Test of changeAction method, of class Creature.
     */
    @Test
    public void testChangeAction() {
        Action newAction = action;
        instance.changeAction(newAction);
        assertEquals(instance.getCurrentAction().getAction(), action);
    }

    /**
     * Test of setController method, of class Creature.
     */
    @Test
    public void testSetController() {
        CreatureController controller = new BasicAIController();
        instance.setController(controller);
        assertEquals(instance.getController(), controller);
    }

    /**
     * Test of getController method, of class Creature.
     */
    @Test
    public void testGetController() {
        CreatureController expResult = creatureController;
        CreatureController result = instance.getController();
        assertEquals(expResult, result);
    }

    //TODO Test of updateKnowledge method, of class Creature.
    /**
     * Test of setPosition method, of class Creature.
     */
    @Test
    public void testSetPosition() {
        Position newPosition = new Position(5, 5);
        instance.setPosition(newPosition);
        assertTrue(instance.getPosition().equals(newPosition));
    }

    //TODO Test of initializeKnowledge method, of class Creature.
    /**
     * Test of addMovementToDirection method, of class Creature.
     */
    @Test
    public void testAddMovementToDirection() {
        Direction direction = Direction.DOWN;
        assertFalse(instance.getMovementVector().potentiallyMoving());
        instance.addMovementToDirection(direction);
        assertTrue(instance.getMovementVector().potentiallyMoving());
    }

    /**
     * Test of getDescription method, of class Creature.
     */
    @Test
    public void testGetDescription() {
        Description expResult = descrb;
        Description result = instance.getDescription();
        assertEquals(expResult, result);
    }

    //TODO Test of advanceTimestep method, of class Creature.
    public class CreatureImpl extends Creature {

        public CreatureImpl(Position position, Description description, CreatureController creatureController) {
            super(position, description, creatureController);
        }
    }

    private class MockupAction extends Move {

        boolean executed = false;

        @Override
        public int calculateTimeUntilComplete(Creature creature) {
            return 0;
        }

        @Override
        public void execute(Creature creature) {
            executed = true;
        }

        public boolean wasExecuted() {
            return executed;
        }
    }

}
