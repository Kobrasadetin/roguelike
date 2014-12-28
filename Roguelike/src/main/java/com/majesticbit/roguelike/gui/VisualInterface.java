/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.BasicLevel;
import com.majesticbit.roguelike.domain.Level;

/**
 *
 * @author Master
 */
public abstract class VisualInterface {

    protected Level level;

    public void setLevel(Level level) {
        this.level = level;
    }

    public abstract void draw();

}
