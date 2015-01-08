/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.simulation;

import com.majesticbit.roguelike.domain.GameEvent;
import com.majesticbit.roguelike.domain.dungeon.Tile;

/**
 *
 * @author Master
 */
public class CollisionEvent extends GameEvent {

    private DynamicObject collider;
    private Tile collidedTo;
    private DynamicObject collidedObj;
    private boolean dynamic;

    public CollisionEvent(DynamicObject collider, Tile collidedTo) {
        this.collider = collider;
        this.collidedTo = collidedTo;
        dynamic = false;

    }

    public CollisionEvent(DynamicObject collider, DynamicObject collidedTo) {
        this.collider = collider;
        this.collidedObj = collidedTo;
        dynamic = true;
    }

    @Override
    public boolean printsMessage() {
        return true;
    }

    @Override
    public String getMessage() {
        switch (dynamic ? 1 : 0) {
            case 1:
                return dynamicMessage();
            case 0:
                return tileMessage();
        }
        throw new IllegalArgumentException("Dynamic message errorcode -48");
    }

    public String dynamicMessage() {
        return (collider.getDescription().getText() + " collided with " + collidedObj.getDescription().getText()
                + '\n' + collidedObj.getDescription().getText() + " was pushed!");
    }

    public String tileMessage() {
        return (collider.getDescription().getText() + " collided with " + collidedTo.getDescription().getText());
    }

}
