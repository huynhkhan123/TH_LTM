/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Balls extends Thread{
    private JPanel box;
    private static final int XSIZE = 50;
    private static final int YSIZE = 50;
    private int x = 0;
    private int y = 0;
    private int dx = 10;
    private int dy = 10;
    private Color color;
    
     public Balls(JPanel _box) {
        this.box = _box;
        this.box.setBackground(Color.WHITE);
    }
     
    public void draw() {
        Graphics graphic = box.getGraphics();
        color = randomColor();
        graphic.setColor(color);
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
            color = randomColor();
        }
        if (x + XSIZE >= d.getWidth()) {
            x = d.width - XSIZE;
            dx = -dx;
            color = randomColor();
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
            color = randomColor();
        }
        if (y + YSIZE >= d.getHeight()) {
            y = d.height - YSIZE;
            dy = -dy;
            color = randomColor();
        }
        graphic.setColor(color);
        graphic.fillOval(x, y,XSIZE, YSIZE);
        graphic.dispose();
    }
    
    public Color randomColor(){
        Random randomGenerator = new Random();
        int red = randomGenerator.nextInt(256);
        int green = randomGenerator.nextInt(256);
        int blue = randomGenerator.nextInt(256);
        return new Color(red,green,blue);
    } 
    
    @Override
    public void run(){
        draw();
        for(int i = 0; i < 5000; i++){
            move();
            try {
                sleep(20);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR);
            }
        }
    }
}
