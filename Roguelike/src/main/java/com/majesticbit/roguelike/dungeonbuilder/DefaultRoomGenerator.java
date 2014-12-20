/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.dungeonbuilder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Master
 */
public class DefaultRoomGenerator implements RoomGenerator {

    private List<Element> elements;

    @Override
    public List<Element> generate(Settings settings) {
        //TODO
        elements = new ArrayList();
        elements.add(new Room(0, 0, 10, 19));
        elements.add(new Room(20, 0, 29, 19));
        elements.add(new Corridor(1, 8, 29, 8));
        return elements;
    }

}
