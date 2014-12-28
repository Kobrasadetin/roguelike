/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike;

import com.majesticbit.roguelike.domain.Game;
import com.majesticbit.roguelike.gui.UserInterface;

/**
 *
 * @author Master
 */
public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Game game = new Game(ui);
        game.play();
    }
}
