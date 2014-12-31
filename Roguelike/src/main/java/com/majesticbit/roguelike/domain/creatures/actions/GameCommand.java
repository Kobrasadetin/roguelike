/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.creatures.actions;

import com.majesticbit.roguelike.domain.creatures.Creature;
import java.util.Objects;

/**
 *
 * @author Master
 */
public class GameCommand extends Action {

    private final String command;

    public GameCommand(String command) {
        this.command = command;
    }

    @Override
    public int calculateTimeUntilComplete(Creature creature) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.command);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameCommand other = (GameCommand) obj;
        if (!Objects.equals(this.command, other.command)) {
            return false;
        }
        return true;
    }

}
