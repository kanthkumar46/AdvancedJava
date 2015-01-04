package com.rit.homework;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
 

class DrawIt extends Thread{
	int px , py;
    private double zx, zy, cX, cY, tmp;
    private final int MAX = 5000;
    private final int LENGTH   = 800;
    private final double ZOOM  = 1000;
    
	public DrawIt(int x, int y) {
		px = x;
		py = y;
	}
	
	@Override
	public void run() {
        zx = zy = 0;
        cX = (px - LENGTH) / ZOOM;
        cY = (py - LENGTH) / ZOOM;
        int iter = 0;
        while ( (zx * zx + zy * zy < 4 ) && ( iter < MAX - 1 ) ) {
            tmp = zx * zx - zy * zy + cX;
            zy = 2.0 * zx * zy + cY;
            zx = tmp;
            iter++;
        }
        if ( iter > 0 )
        	Mandelbrot.I.setRGB(px, py, Mandelbrot.colors[iter]);
        else
        	Mandelbrot.I.setRGB(px, py, iter | (iter << 8));
	}
}

@SuppressWarnings("serial")
public class Mandelbrot extends JFrame {
 
    private final static int MAX = 5000;
    private final int LENGTH   = 800;
    public static BufferedImage I;
    static int[] colors = new int[MAX];
 
    public Mandelbrot() {
        super("Mandelbrot Set");
	
        initColors();
        setBounds(100, 100, LENGTH, LENGTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void createSet()	{
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
            	new DrawIt(x, y).start();
            	repaint();
            }
        }
    }
    
    public void initColors() {
        for (int index = 0; index < MAX; index++) {
            colors[index] = Color.HSBtoRGB(index/256f, 1, index/(index+8f));
        }
    }
 
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }
 
    public static void main(String[] args) {
        Mandelbrot aMandelbrot = new Mandelbrot();
        aMandelbrot.setVisible(true);
        aMandelbrot.createSet();
    }
}