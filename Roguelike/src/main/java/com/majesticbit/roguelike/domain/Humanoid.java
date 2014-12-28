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
public class Humanoid extends Creature {

    public Humanoid(Position position, Description description) {
        super(position, description, new BasicAIController());

    }

    public Humanoid(Position position, Description description, CreatureController controller) {
        super(position, description, controller);

    }
}
