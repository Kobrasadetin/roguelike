/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures;

import java.util.ArrayList;

/**
 *
 * @author Master
 */
public class Properties {


    private int movementDelay;

    public int getMovementDelay() {
        return movementDelay;
    }

    public void setMovementDelay(int movementDelay) {
        this.movementDelay = movementDelay;
    }

    public Properties() {
        this.movementDelay = 20;
    }
}
