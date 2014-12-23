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

    public static final Settings DEFAULT_SETTINGS = new DefaultSettings();

    public static class DefaultSettings implements Settings {

        static final int WIDTH = 30;
        static final int HEIGHT = 20;

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
