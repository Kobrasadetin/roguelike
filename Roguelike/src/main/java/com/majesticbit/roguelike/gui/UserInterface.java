/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.level.BasicLevel;
import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.gui.VisualInterface;
import com.majesticbit.roguelike.gui.AsciiViewer;

/**
 *
 * @author Master
 */
public class UserInterface {

    private VisualInterface visualInterface;

    public UserInterface() {
        visualInterface = new AsciiViewer();
    }

    public void drawAscii(Level level) {
        visualInterface.draw(level);
    }

}
