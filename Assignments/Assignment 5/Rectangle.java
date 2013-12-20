//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Rectangle class

import java.awt.Graphics;
public class Rectangle extends ClosedShape{

    public Rectangle(int x, int y, int width, int height){
        super(true,4);
        setWidth(width);
        setHeight(height);
        //CORNERS: top left, bottom left, bottom right, top right in array
        int [] xArray = {x, x, x+width, x+width};
        int [] yArray = {y, y-height, y-height, y};
        setXYCoords(xArray,yArray);
    }

    public double Perimeter(){
        return 2*width+2*height;
    }

    public double Area(){
        return width*height;
    }
}