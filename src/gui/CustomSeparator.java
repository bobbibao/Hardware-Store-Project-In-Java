package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JSeparator;

class CustomSeparator extends JSeparator {
	private static final long serialVersionUID = 1L;
	private Color color;
    private int thickness;
    private int height;

    public CustomSeparator(Color color, int thickness, int height) {
        this.color = color;
        this.thickness = thickness;
        this.height = height;
        setOpaque(true);
        setBackground(color);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        int x = (getWidth() - thickness) / 2;
        g.fillRect(x, 0, thickness, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(thickness, height);
    }
}