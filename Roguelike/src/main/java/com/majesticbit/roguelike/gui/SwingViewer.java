/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.dungeon.Tile;
import com.majesticbit.roguelike.domain.simulation.DynamicObject;
import com.majesticbit.roguelike.domain.level.Level;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import squidpony.squidgrid.gui.SGPane;
import squidpony.squidgrid.gui.swing.SwingPane;

/**
 *
 * @author Master
 */
public class SwingViewer extends VisualInterface implements KeyEventListener, KeyEventTrigger, ActionListener {

    private int width, height;
    private SwingPane pane;
    private JPanel anotherPanel;
    private JPanel anotherPanel2;
    private JScrollPane mapScrollPane;
    private GameFrame frame;
    private List<KeyEventListener> keyListeners;

    public SwingViewer() {
        pane = new ScrollableSwingPane();
        pane.initialize(30, 20, new Font("TimesRoman", Font.PLAIN, 18));
        frame = new GameFrame();
        frame.addMapComponent(pane);
        frame.setVisible(true);
        keyListeners = new ArrayList();
        assignInputMap();
    }

    private void assignInputMap() {
        frame.getButton().addActionListener(this);
        createAction('w', "w");
        createAction('a', "a");
        createAction('s', "s");
        createAction('d', "d");

    }

    private void createAction(char key, String name) {
        InputMap frameInputMap = frame.getButton().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap frameActionMap = frame.getButton().getActionMap();
        frameInputMap.put(KeyStroke.getKeyStroke(key), name);
        frameActionMap.put(name, new UIAction(name, this));
    }

    @Override
    public void draw(Level level) {
        pane.placeText(0, 0, characterMap(level));
        pane.refresh();
    }

    public static char[][] characterMap(Level level) {

        Dungeon dungeon = level.getDungeon();
        int width = dungeon.getWidth();
        int height = dungeon.getHeight();
        char[][] map = new char[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Tile tile = dungeon.getTile(x, y);
                map[x][y] = tile.getDescription().getSymbol();
            }
        }

        // draw creatures and other dynamic objects
        for (DynamicObject object : level.getObjects()) {
            Position pos = object.getPosition();
            map[pos.x][pos.y] = object.getDescription().getSymbol();
        }

        return map;
    }

    @Override
    public void addKeyEventListener(KeyEventListener listener) {
        keyListeners.add(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action:");
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("quit")) {
            keyPressed("q");
        }
    }

    @Override
    public void keyPressed(String keypress) {
        for (KeyEventListener listener : keyListeners) {
            listener.keyPressed(keypress);
        }
    }

    @Override
    public void showMessage(String message) {
        this.frame.getMessageArea().append(message + '\n');
    }

}
