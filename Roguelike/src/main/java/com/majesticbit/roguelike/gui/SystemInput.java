/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import com.majesticbit.roguelike.domain.creatures.Creature;
import com.majesticbit.roguelike.domain.creatures.actions.Action;
import java.util.Scanner;

/**
 *
 * @author Master
 */
public class SystemInput implements PlayerInput {

    private Scanner scanner;

    public SystemInput() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Action getAction(Creature creature) {
        System.out.println("wasd to move, q to quit:");
        String input = scanner.nextLine();
        return Parser.parse(creature, input);
    }

}
