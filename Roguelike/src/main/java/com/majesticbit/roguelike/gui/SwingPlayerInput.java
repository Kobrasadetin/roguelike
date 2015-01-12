/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.creatures.actions.Action;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Master
 */
public class SwingPlayerInput implements PlayerInput, KeyEventListener {

    //TODO:
    //use keybindings instead of KeyEvents
    //http://docs.oracle.com/javase/tutorial/uiswing/misc/keybinding.html#inputmap
    private SwingViewer swingViewer;

    private String lastKeyEvent;

    public SwingPlayerInput(SwingViewer swingViewer) {

    }

    @Override
    public Action getAction() {
        while (lastKeyEvent == null) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
                Logger.getLogger(SwingPlayerInput.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String keypress = lastKeyEvent;
        lastKeyEvent = null;
        return Parser.parse(keypress);
    }

    @Override
    public void keyPressed(String keypress) {
        lastKeyEvent = keypress;
    }

}
