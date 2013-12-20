//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Class
/*
 * Main.java
 *
*/

import javax.swing.JFrame;

public class Main
{
  public static final int WIDTH = 400;
  public static final int HEIGHT = 400;

  public static void main(String[] args)
  {
    JFrame drawingFrame = new JFrame ("Draw!");
    drawingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    DrawingFrame  draw = new DrawingFrame(WIDTH, HEIGHT);
    draw.setOpaque(true);

    drawingFrame.setContentPane(draw);
    drawingFrame.setSize(WIDTH,HEIGHT);
    drawingFrame.setVisible(true);
  }
}