/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.simulation;

import com.majesticbit.roguelike.domain.GameEvent;
import com.majesticbit.roguelike.domain.GameEventBroadcaster;
import com.majesticbit.roguelike.domain.GameEventListener;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.domain.dungeon.ChangeEventListener;
import com.majesticbit.roguelike.domain.dungeon.ChangeEventTrigger;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.dungeon.Tile;
import java.util.ArrayList;
import java.util.List;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public abstract class DynamicSystem implements ChangeEventTrigger, GameEventBroadcaster {

    private int currentTime = 0;

    protected abstract Dungeon getSimulatedDungeon();

    protected abstract List<DynamicObject> dynamicObjects();

    protected abstract List<Creature> dynamicCreatures();

    protected abstract void updateCreatures();

    private List<ChangeEventListener> changeEventListeners;
    private List<GameEventListener> gameEventListeners;

    public DynamicSystem() {
        changeEventListeners = new ArrayList();
        gameEventListeners = new ArrayList();
    }

    /**
     * Simulates one timestep.
     */
    public void advanceOneTimestep() {

        //updateCreatures gives the creatures a chance to make decisions
        updateCreatures();

        List<DynamicObject> dynamicObjects = dynamicObjects();
        for (DynamicObject object : dynamicObjects) {
            object.advanceTimestep();
            MovementVector vector = object.getMovementVector();
            if (vector.potentiallyMoving()) {
                Direction displacement = vector.checkDisplacement();
                Position newPosition = Position.displacedPosition(object.getPosition(), displacement);
                int newX = object.getPosition().x + displacement.deltaX;
                int newY = object.getPosition().x + displacement.deltaX;
                Tile collidedTile = checkTileCollision(newPosition);
                if (collidedTile == null) {
                    //no collision with tile
                    DynamicObject collider = checkObjectCollision(newPosition);
                    if (collider == null) {
                        //no collision at all
                        object.setPosition(newPosition);
                        vector.performDisplacement();
                    } else {
                        handleObjectCollision(object, collider);
                        vector.performDisplacement();
                    }
                } else {
                    handleTileCollision(object, collidedTile);
                    vector.performDisplacement();
                }
            }
        }
        currentTime++;
    }

    /**
     *
     * @return current amount of timesteps the simulation has advanced.
     */
    public int getCurrentTime() {
        return currentTime;
    }

    // returns true if object  *can*  occupy the selected tile
    private Tile checkTileCollision(Position position) {
        Tile tile = getSimulatedDungeon().getTile(position.x, position.y);
        if (tile.isSolid()) {
            return tile;
        }
        return null;
    }

    private DynamicObject checkObjectCollision(Position position) {
        for (DynamicObject object : dynamicObjects()) {
            if ((object.getPosition()).equals(position)) {
                return object;
            }
        }
        return null;
    }

    private void handleObjectCollision(DynamicObject object, DynamicObject collidesWith) {
        broadcastGameEvent(new CollisionEvent(object, collidesWith));
        collidesWith.addMovementToDirection(object.getMovementVector().checkDisplacement());
    }

    private void handleTileCollision(DynamicObject object, Tile collidedTile) {
        broadcastGameEvent(new CollisionEvent(object, collidedTile));
    }

    @Override
    public void addChangeEventListener(ChangeEventListener toAdd) {
        changeEventListeners.add(toAdd);
    }

    @Override
    public void addMessageListener(GameEventListener listener) {
        gameEventListeners.add(listener);
    }

    protected void broadcastGameEvent(GameEvent event) {
        for (GameEventListener listener : gameEventListeners) {
            listener.processGameEvent(event);
        }
    }

}
