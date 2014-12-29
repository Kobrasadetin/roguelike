/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures;

import com.majesticbit.roguelike.domain.level.BasicLevel;
import com.majesticbit.roguelike.domain.Description;
import com.majesticbit.roguelike.domain.level.DynamicObject;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.creatures.actions.Action;

/**
 *
 * @author Master
 */
public abstract class Creature implements DynamicObject {

    private Description description;
    private Position position;
    private CreatureController controller;
    private Action currentAction;

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
    }

    /**
     *
     * @return the creature's current unfinished action.
     */
    public Action getCurrentAction() {
        return currentAction;
    }

    /**
     *
     * @return Creature Properties
     */
    public Properties getProperties() {
        return properties;
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
     * setPosition calls Position.set() of the creature's position
     *
     * @param position the new position of the creature
     */
    public void setPosition(Position position) {
        this.position.set(position);
    }

    /**
     *
     * @param level
     */
    public void bestowKnowledge(BasicLevel level) {
        controller.initializeKnowledge(level);
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public Position getPosition() {
        return position;
    }

}
