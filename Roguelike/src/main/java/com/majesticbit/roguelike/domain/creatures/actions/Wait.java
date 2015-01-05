/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures.actions;

import com.majesticbit.roguelike.domain.creatures.Creature;

/**
 *
 * @author Master
 */
public class Wait extends Action {

    public Wait() {
    }

    @Override
    public int calculateTimeUntilComplete() {
        return 20;
    }

}
