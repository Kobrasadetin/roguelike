/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain;

import com.majesticbit.roguelike.domain.dungeon.BasicTile;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Master
 */
public class TextDescriptionTest {

    String text;
    char character;
    TextDescription instance;

    public TextDescriptionTest() {
    }

    @Before
    public void setUp() {
        text = "testing";
        character = 'g';
        instance = new TextDescription(text, character);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getText method, of class TextDescription.
     */
    @Test
    public void testGetText() {
        String result = instance.getText();
        String expResult = text;
        assertEquals(expResult, result);
    }

    /**
     * Test of getSymbol method, of class TextDescription.
     */
    @Test
    public void testGetSymbol() {
        char expResult = character;
        char result = instance.getSymbol();
        assertEquals(expResult, result);
    }

}
