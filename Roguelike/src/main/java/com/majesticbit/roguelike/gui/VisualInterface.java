/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.level.BasicLevel;
import com.majesticbit.roguelike.domain.level.Level;

/**
 *
 * @author Master
 */
public abstract class VisualInterface {

    public abstract void draw(Level level);

    public abstract void showMessage(String message);

}
