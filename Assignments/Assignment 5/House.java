//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Class
public class House extends Compound{
    Rectangle houseFrame;
    Triangle roof;

    //height = height of house
    //width = wideness of house
    //x,y = coordinates of the bottom left corner of house
    public House(int x, int y, int width, int height){
        super();
        houseFrame = new Rectangle(x,y,width,height);
        roof = new Triangle(x,y+height,width,height/2);
    }

}