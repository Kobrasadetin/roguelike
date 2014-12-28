package com.majesticbit.roguelike.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.majesticbit.roguelike.domain.dungeon.BasicDungeon;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import com.majesticbit.roguelike.domain.dungeon.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Master
 */
public class BasicDungeonTest {

    private Dungeon dungeon;
    private int width = 20;
    private int height = 20;

    public BasicDungeonTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dungeon = new BasicDungeon(width,height);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TestForTilesInMap() {
        Tile tile = dungeon.getTile(0, 0);
        assertTrue(tile!=null);
    }
    @Test
    public void TestForTilesInMapNotOutOfBounds() {
        Tile tile = dungeon.getTile(0, 0);
        assertTrue(tile!=Tile.OUT_OF_BOUNDS);
    }
    @Test
    public void TestForTilesOutsideMapWidth() {
        Tile tile = dungeon.getTile(width+1, 0);
        assertTrue(tile==Tile.OUT_OF_BOUNDS);
    }
    @Test
    public void TestForTilesOutsideMapHeight() {
        Tile tile = dungeon.getTile(width-1, height+1);
        assertTrue(tile==Tile.OUT_OF_BOUNDS);
    }
}
