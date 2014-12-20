/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.dungeonbuilder;

/**
 *
 * @author Master
 */
public interface Settings {

    public int getWidth();

    public int getHeight();

    public static Settings DEFAULT_SETTINGS = new DEFAULT_SETTINGS();

    public static class DEFAULT_SETTINGS implements Settings {

        int WIDTH = 30;
        int HEIGHT = 20;

        @Override
        public int getWidth() {
            return WIDTH;
        }

        @Override
        public int getHeight() {
            return HEIGHT;
        }

    }
}
