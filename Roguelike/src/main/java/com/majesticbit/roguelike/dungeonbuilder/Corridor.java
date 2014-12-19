/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.dungeonbuilder;

import java.util.List;

/**
 *
 * @author Master
 */
public class Corridor implements Element{
      
    private List<Corridor> subcorridors;
    
    private int x1,x2,x3,x4;

    @Override
    public boolean isWall(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOpen(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
