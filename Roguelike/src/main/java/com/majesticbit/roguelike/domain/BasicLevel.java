/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Master
 */
public class BasicLevel implements Level {

    private Dungeon dungeon;
    private List<DynamicObject> objects;
    private List<Creature> creatures;

    @Override
    public List<DynamicObject> getObjects() {
        return objects;
    }

    @Override
    public Dungeon getDungeon() {
        return dungeon;
    }

    public BasicLevel(Dungeon dungeon) {
        this.dungeon = dungeon;
        objects = new ArrayList();
        creatures = new ArrayList();
    }

    public boolean addCreature(Creature creature, Position position) {
        //check if position is unoccupied and not solid
        if (!dungeon.getTile(position.x, position.y).isSolid()) {
            if (isUnoccupied(position)) {
                objects.add(creature);
                creature.setPosition(position);
                creatures.add(creature);
            }
            return true;
        }
        return false;
    }

    private boolean isUnoccupied(Position position) {
        for (DynamicObject object : objects) {
            if (position.equals(object.getPosition())) {
                return false;
            }
        }
        return true;
    }

}
