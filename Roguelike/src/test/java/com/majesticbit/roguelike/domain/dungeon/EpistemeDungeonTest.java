/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.dungeon;

import com.majesticbit.roguelike.dungeonbuilder.DungeonBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Master
 */
public class EpistemeDungeonTest {

    Dungeon dungeon;
    EpistemeDungeon instance;

    public EpistemeDungeonTest() {
    }

    @Before
    public void setUp() {
        dungeon = new DungeonBuilder().toDungeon();
        instance = new EpistemeDungeon(dungeon);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getWidth method
     */
    @Test
    public void testGetWidth() {
        int expResult = dungeon.getWidth();
        int result = instance.getWidth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHeight method
     */
    @Test
    public void testGetHeight() {
        int expResult = dungeon.getHeight();
        int result = instance.getHeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of revealAllTiles method, of class EpistemeDungeon.
     */
    @Test
    public void testRevealAllTiles() {
        assertTrue(instance.getTile(0, 0) == Tile.UNKNOWN);
        instance.revealAllTiles();
        assertTrue(instance.getTile(0, 0) != Tile.UNKNOWN);
    }

    /**
     * Test of revealUsingFloatMask method, of class EpistemeDungeon.
     */
    @Test
    public void testRevealUsingFloatMask() {
        assertTrue(instance.getTile(0, 0) == Tile.UNKNOWN);
        float[][] mask = new float[instance.getWidth()][instance.getHeight()];
        mask[0][0] = 0.2F;
        float threshold = 0.1F;
        instance.revealUsingFloatMask(mask, threshold);
        assertTrue(instance.getTile(0, 0) != Tile.UNKNOWN);
    }

    @Test
    public void testForNNull() {
        Tile tile = instance.getTile(0, 0);
        assertTrue(tile != null);
    }

    @Test
    public void testForTilesInMapNotOutOfBounds() {
        Tile tile = instance.getTile(0, 0);
        assertTrue(tile != Tile.OUT_OF_BOUNDS);
    }

    @Test
    public void testForTilesOutsideMapWidth() {
        Tile tile = instance.getTile(instance.getWidth() + 1, 0);
        assertTrue(tile == Tile.OUT_OF_BOUNDS);
    }

    @Test
    public void testForTilesOutsideMapHeight() {
        Tile tile = instance.getTile(instance.getWidth() - 1, instance.getHeight() + 1);
        assertTrue(tile == Tile.OUT_OF_BOUNDS);
    }

}
