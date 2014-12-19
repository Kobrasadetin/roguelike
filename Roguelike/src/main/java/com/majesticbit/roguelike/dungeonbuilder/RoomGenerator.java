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
public interface RoomGenerator {
    public List<Element> generate(Settings settings);
}
