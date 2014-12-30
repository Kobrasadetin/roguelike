/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.domain.fov;

import com.majesticbit.roguelike.domain.dungeon.ChangeEventListener;
import com.majesticbit.roguelike.domain.level.Level;
import com.majesticbit.roguelike.domain.Position;
import com.majesticbit.roguelike.domain.dungeon.Dungeon;
import squidpony.squidgrid.fov.EliasFOV;
import squidpony.squidgrid.fov.FOVSolver;

/**
 *
 * @author Master
 */
public class VisibilitySolver implements ChangeEventListener {

    private static final int RADIUS = 15;
    private float[][] dungeonVisibilityMap;
    private Level level;
    private Dungeon dungeon;
    private FOVSolver solver;

    public VisibilitySolver(Level level, FOVSolver solver) {
        this.level = level;
        this.solver = solver;
        dungeon = level.getDungeon();
        dungeon.addChangeEventListener(this);
        dungeonVisibilityMap = convertToVisibilityMap(level);
    }

    public VisibilitySolver(Level level) {
        this(level, new EliasFOV());
    }

    private float[][] convertToVisibilityMap(Level level) {
        int width = dungeon.getWidth();
        int height = dungeon.getHeight();
        float[][] map = new float[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                map[x][y] = dungeon.getTile(x, y).isSolid() ? 1f : 0f;
            }
        }
        return map;
    }

    public float[][] calculateVisibility(Position position) {
        int width = dungeon.getWidth();
        int height = dungeon.getHeight();
        float[][] map = solver.calculateFOV(dungeonVisibilityMap, position.x, position.y, RADIUS);
        return map;
    }

    @Override
    public void somethingHasChanged() {
        dungeonVisibilityMap = convertToVisibilityMap(level);
    }

}
