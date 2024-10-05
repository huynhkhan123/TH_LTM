/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Administrator
 */
public class Ball {
    private JPanel box;
    private static final int XSIZE = 50;
    private static final int YSIZE = 50;
    private int x = 0;
    private int y = 0;
    private int dx = 10;
    private int dy = 10;

    public Ball(JPanel _box) {
        this.box = _box;
        this.box.setBackground(Color.WHITE);
    }

    public void draw() {
        Graphics graphic = box.getGraphics();
        
//        graphic.setColor(Color.RED);
        graphic.fillOval(x, y, XSIZE, YSIZE);
    }

    public void move() {
        Graphics graphic = box.getGraphics();
        graphic.setColor(Color.WHITE);
        graphic.fillOval(x, y, XSIZE, YSIZE);
        // Calculate new position
        x += dx;
        y += dy;
        // Get the dimensions of the box
        Dimension d = box.getSize();

        // Bounce off the walls
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= d.getWidth()) {
            x = d.width - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= d.getHeight()) {
            y = d.height - YSIZE;
            dy = -dy;
        }
        graphic.setColor(Color.RED);
        graphic.fillOval(x, y,XSIZE, YSIZE);
        graphic.dispose();
    }

    public void bounce(){
        draw();
        for(int i = 0; i < 1000; i++){
            move();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR);
            }
        }
    }

//    public void paintComponent(Graphics g) {
//        draw(g);
//    }
}
