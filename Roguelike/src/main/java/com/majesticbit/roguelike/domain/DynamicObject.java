/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import java.util.List;

/**
 *
 * @author Master
 */
public interface DynamicObject {

    /**
     * Returns description of the object
     *
     * @return Description containing description of the object
     */
    public Description getDescription();

    /**
     * Returns the position of the object
     *
     * @return Position, object's position
     */
    public Position getPosition();

}
