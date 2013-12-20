//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Circle class
public class Circle extends Oval{

    public static final double PI = Math.PI;

    public Circle(int x, int y, int radius){
        super(x,y,radius,radius);
        setWidth(width);
        setHeight(height);
    }

    public double Perimeter(){
        return 2*PI*width;
    }

    public double Area(){
        return PI*width*width;
    }
}