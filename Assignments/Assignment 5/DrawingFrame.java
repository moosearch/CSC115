//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Class for drawing shapes
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class DrawingFrame extends javax.swing.JPanel
{
    public DrawingFrame (int w, int h)
    {
        setFocusable(true);
        setBackground(Color.black);
        setSize(w,h);
    }
    //x is some shape, y is some colour
    protected void paintComponent(Graphics g/*, Shape xx, Color yx*/)
    {
        //super.paintComponent(g);
        //g.setColor(yy);
        //xx.draw(g);
        //tester  : Remove comments to test classes
        Shape mine = new Rectangle(400, 300, 30, 60);
        g.setColor(Color.red);
        mine.draw(g);

        mine = new Rectangle(500, 150, 90, 50);
        g.setColor(Color.red);
        mine.draw(g);

        mine = new Oval(300, 300, 120, 80);
        g.setColor(Color.green);
        mine.draw(g);

        mine = new Circle(300, 200, 60);
        g.setColor(Color.red);
        mine.draw(g);

        g.setColor(Color.yellow);
        g.drawString("Hello world!", 300,200);

        //mine = new Line(100,100,0,60);
        //g.setColor(Color.blue);
        //mine.draw(g);

        int[] x = {100, 100, 200, 200};
        int[] y = {500, 200, 200, 500};//*/



        //g.fillPolygon(x,y,3);

    }


}
