/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keilly.paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import javax.swing.UIManager;

/**
 * Paint arbitrary text.
 */
public class TextPainter implements Painter {
    private final Font font;
    private final String text;
    private final Color color;
    
    public TextPainter(String text, Font font, Color color){
        this.text = text;
        this.font = font != null ? font : UIManager.getFont("Label.font");
        this.color = color != null ? color : UIManager.getColor("Label.foreground");
    }

    @Override
    public Rectangle getBounds(JPainted paintComponent) {
        Graphics2D g2 = (Graphics2D)paintComponent.getGraphics();
        g2.setFont(font);
        FontRenderContext frc = g2.getFontRenderContext();
        TextLayout layout = new TextLayout(text, font, frc);
        Rectangle2D r2 = layout.getBounds();
        return r2.getBounds();
    }
    

    @Override
    public void paint(JPainted paintComponent, Graphics2D g2) {
        g2.setColor(color);
        g2.setFont(font);
        FontRenderContext frc = g2.getFontRenderContext();
        TextLayout layout = new TextLayout(text, font, frc);
        layout.draw(g2, 0, (float)layout.getBounds().getHeight());
    }
    
}
