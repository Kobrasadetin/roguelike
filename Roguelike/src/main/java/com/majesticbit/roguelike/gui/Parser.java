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
        return parse(input);
    }

    public static Action parse(char input) {
        switch (input) {
            case '8':
                return Action.move(Direction.UP);
            case '4':
                return Action.move(Direction.LEFT);
            case '2':
                return Action.move(Direction.DOWN);
            case '6':
                return Action.move(Direction.RIGHT);
            case '7':
                return Action.move(Direction.UP_LEFT);
            case '9':
                return Action.move(Direction.UP_RIGHT);
            case '1':
                return Action.move(Direction.DOWN_LEFT);
            case '3':
                return Action.move(Direction.DOWN_RIGHT);
            case 'q':
                return Action.QUIT;
        }
        return Action.NONE;
    }
}
