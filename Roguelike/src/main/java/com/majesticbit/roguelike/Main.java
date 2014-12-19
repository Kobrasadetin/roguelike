/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike;

import com.majesticbit.roguelike.ascii.AsciiViewer;
import com.majesticbit.roguelike.domain.Dungeon;
import com.majesticbit.roguelike.dungeonbuilder.DungeonBuilder;

/**
 *
 * @author Master
 */
public class Main {
    
    public static void main(String[] args) {
        Dungeon dungeon = new DungeonBuilder().toDungeon();
        AsciiViewer viewer = new AsciiViewer(dungeon);
        System.out.print(viewer.draw());
    }
}
