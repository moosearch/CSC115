//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Class for line shape
import java.awt.*;
public class Line extends OpenShape{
    public static final double PI = Math.PI;
    private double angle;

    public Line(int x, int y, double angle, double length){
        super(length, x, y);
        this.angle = angle; //angle in degrees
    }

    public double getAngle(){
        return angle;
    }

    public void draw(Graphics g){
        int x2 = (int)(length*Math.cos(angle*PI/180));
        int y2 = (int)(length*Math.sin(angle*PI/180));

        int [] x = {initX, initX+x2};
        int [] y = {initY, initY+y2};
        g.drawPolygon(x,y,2);
    }
}