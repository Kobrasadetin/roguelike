/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures;

import com.majesticbit.roguelike.domain.level.BasicLevel;
import com.majesticbit.roguelike.domain.Description;
import com.majesticbit.roguelike.domain.simulation.MovementVector;
import com.majesticbit.roguelike.domain.simulation.DynamicObject;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.creatures.actions.Action;
import com.majesticbit.roguelike.domain.creatures.actions.CreatureAction;
import com.majesticbit.roguelike.domain.level.Level;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public abstract class Creature implements DynamicObject {

    private Description description;
    private Position position;
    private CreatureController controller;
    private MovementVector movement;

    @Override
    public MovementVector getMovementVector() {
        return movement;
    }

    private CreatureAction currentAction;

    /**
     *
     */
    protected Properties properties;

    /**
     * Creature is a DynamicObject with a CreatureController and Properties
     *
     * @param position new Position for the creature
     * @param description the creature's description
     * @param controller the controller for the creature. This can be an AI
     * controller or the player.
     */
    public Creature(Position position, Description description, CreatureController controller) {
        this.position = position;
        this.description = description;
        this.controller = controller;
        this.movement = new MovementVector();
        this.currentAction = new CreatureAction(this);
        this.properties = new Properties();
    }

    /**
     *
     * @return the creature's current unfinished action.
     */
    public CreatureAction getCurrentAction() {
        return currentAction;
    }

    public boolean currentActionIsType(Action action) {
        return currentAction.getAction().isOfType(action);
    }

    public void executeActionIfReady() {
        if (currentAction.isReadyToExecute()) {
            currentAction.execute();
        }
    }

    public void makeDecisions() {
        controller.decideAction();
    }

    /**
     *
     * @return Creature Properties
     */
    public Properties getProperties() {
        return properties;
    }

    public void changeAction(Action newAction) {
        currentAction.setAction(newAction);
    }

    /**
     * Sets the controller for the creature. This can be an AI controller or the
     * player.
     *
     * @param controller
     */
    public void setController(CreatureController controller) {
        this.controller = controller;
    }

    /**
     * Gets the controller of the creature. This can be an AI controller or the
     * player.
     *
     * @return controller
     */
    public CreatureController getController() {
        return controller;
    }

    public void updateKnowledge(Level level) {
        controller.bestowPartialKnowledge(level, level.getVisibilitySolver().calculateVisibility(position));
    }

    @Override
    public void setPosition(Position position) {
        this.position.set(position);
    }

    /**
     *
     * @param level
     */
    public void initializeKnowledge(BasicLevel level) {
        controller.initializeKnowledge(this, level);
    }

    @Override
    public void addMovementToDirection(Direction direction) {
        this.movement.addMovementToDirection(direction);
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void advanceTimestep() {
        currentAction.advanceTimestep();
    }

}
