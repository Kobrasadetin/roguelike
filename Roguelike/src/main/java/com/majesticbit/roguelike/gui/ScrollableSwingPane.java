/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.majesticbit.roguelike.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.Scrollable;
import squidpony.squidgrid.gui.swing.SwingPane;

/**
 *
 * @author Master
 */
public class ScrollableSwingPane extends SwingPane implements Scrollable{
    

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(640,640);
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 16;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 16;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return true;
    }
    
}
