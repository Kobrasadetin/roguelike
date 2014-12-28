/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.dungeon;

import com.majesticbit.roguelike.domain.Description;
import com.majesticbit.roguelike.domain.TextDescription;

/**
 *
 * @author Master
 */
public class TileDescription {
    public static Description BasicDescribtion(Tile tile)
    {
        if (tile.isSolid())
        {
            if (tile.isWall())
            {
                return new TextDescription("A Wall", '#');
            }
            else
            {
                return new TextDescription("Solid Rock", ' ');
            }
        }
        return new TextDescription("Open space", '.');
    }
    
}
