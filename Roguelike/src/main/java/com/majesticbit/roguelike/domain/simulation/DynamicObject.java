/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.simulation;

import com.majesticbit.roguelike.domain.Description;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.creatures.Creature;
import java.util.List;
import squidpony.squidgrid.util.Direction;

/**
 * DynamicObject is an object or creature
 *
 * @author Master
 */
public interface DynamicObject {

    /**
     * Returns description of the object
     *
     * @return Description containing description of the object
     */
    public Description getDescription();

    /**
     * Returns the position of the object
     *
     * @return Position, object's position
     */
    public Position getPosition();

    /**
     * Typically setPosition calls Position.set() of the object's position
     *
     * @param position the new position of the object
     */
    public void setPosition(Position position);

    public void addMovementToDirection(Direction direction);

    public MovementVector getMovementVector();
    
    public void advanceTimestep();

}
