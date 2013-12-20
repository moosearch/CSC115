//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Subclass of ClosedShape
public class Triangle extends ClosedShape{

    public Triangle(int x, int y, int base, int height){
        //ASSUME TRIANGLE IS AN ICSOELES TRIANGLE
        super(true,3);
        setWidth(base);
        setHeight(height);
        //bottom left, top, bottom right
        int [] xArray = {x,x+base/2,x+base};
        int [] yArray = {y,y+height,y};
        setXYCoords(xArray,yArray);
    }
    //return perimeter of triangle
    public double Perimeter(){
        return width+Math.sqrt(Math.pow(width/2,2)+Math.pow(height,2));
    }
    //return area of triangle
    public double Area(){
        return 0.5*width*height;
    }
}