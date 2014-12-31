/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.creatures.actions.Action;
import squidpony.squidgrid.util.Direction;

/**
 *
 * @author Master
 */
public class Parser {

    public static Action parse(String string) {
        char input = '?';
        if (!string.isEmpty()) {
            input = string.charAt(0);
        }
        switch (input) {
            case 'w':
                return Action.move(Direction.UP);
            case 'a':
                return Action.move(Direction.LEFT);
            case 's':
                return Action.move(Direction.DOWN);
            case 'd':
                return Action.move(Direction.RIGHT);
            case 'q':
                return Action.QUIT;
        }
        return Action.NONE;
    }
}
