/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.level;

import com.majesticbit.roguelike.domain.simulation.DynamicObject;
import com.majesticbit.roguelike.domain.simulation.DynamicSystem;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.fov.VisibilitySolver;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Master
 */
public class BasicLevel extends DynamicSystem implements Level {

    private Dungeon dungeon;
    private List<DynamicObject> objects;
    private List<Creature> creatures;
    private int currentTime;
    private VisibilitySolver visibilitySolver;

    public BasicLevel(Dungeon dungeon) {
        this.dungeon = dungeon;
        this.objects = new ArrayList();
        this.creatures = new ArrayList();
        this.visibilitySolver = new VisibilitySolver(this);
    }

    public boolean addCreature(Creature creature, Position position) {
        //check if position is unoccupied and not solid
        if (!dungeon.getTile(position.x, position.y).isSolid()) {
            if (isUnoccupied(position)) {
                objects.add(creature);
                creature.setPosition(position);
                creatures.add(creature);
                creature.initializeKnowledge(this);
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

    @Override
    public VisibilitySolver getVisibilitySolver() {
        return visibilitySolver;
    }

    @Override
    public List<DynamicObject> getObjects() {
        return objects;
    }

    @Override
    public Dungeon getDungeon() {
        return dungeon;
    }

    @Override
    protected List<DynamicObject> dynamicObjects() {
        return getObjects();
    }

    @Override
    protected Dungeon getSimulatedDungeon() {
        return getDungeon();
    }

    @Override
    protected List<Creature> dynamicCreatures() {
        return creatures;
    }

    @Override
    protected void updateCreatures() {
        for (Creature creature : creatures) {
            creature.updateKnowledge(this);
            creature.makeDecisions();
            creature.executeActionIfReady();
        }
    }

}