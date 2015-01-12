/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 * @author Master
 */
public class UIAction extends AbstractAction {

    private String name;
    private KeyEventListener listener;

    public UIAction(String name, KeyEventListener listener) {
        this.name = name;
        this.listener = listener;
    }

    UIAction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listener.keyPressed(name);
    }

}
