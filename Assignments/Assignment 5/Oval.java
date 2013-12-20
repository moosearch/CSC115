//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Oval Class
public class Oval extends ClosedShape{

    public static final double PI = Math.PI;

    public Oval(int x, int y, int width, int height){
        super(false,4);
        setWidth(width);
        setHeight(height);
        //Demensions for bounding box, top left, bottom left, bottom right, top right
        int [] xArray = {x-width/2,x-width/2,x+width/2,x+width/2}; //
        int [] yArray = {y+height/2,y-height/2,y-height/2,y+height/2};
        setXYCoords(xArray,yArray);
    }

    public double Perimeter(){
        return 2*PI*Math.sqrt((height*height+width*width)/2);
    }

    public double Area(){
        return width*height*4/5;
    }

}