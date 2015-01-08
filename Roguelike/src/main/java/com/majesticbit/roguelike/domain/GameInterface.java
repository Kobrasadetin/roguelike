/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.creatures.actions.Action;
import com.majesticbit.roguelike.domain.level.Level;

/**
 *
 * @author Master
 */
public interface GameInterface {
    
    public Action getPlayerAction(Level level);
    
    public void showMessage(String message);
    
}
