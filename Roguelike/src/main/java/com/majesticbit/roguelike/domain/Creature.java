/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

/**
 *
 * @author Master
 */
public abstract class Creature implements DynamicObject {

    private Description description;
    private Position position;
    private CreatureController controller;

    public void setPosition(Position position) {
        this.position.set(position);
    }

    public Creature(Position position, Description description, CreatureController controller) {
        this.position = position;
        this.description = description;
        this.controller = controller;
    }

    public void bestowKnowledge(BasicLevel level) {
        controller.bestowKnowledge(level);
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
