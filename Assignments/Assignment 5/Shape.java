//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Superclass for OpenShapre and ClosedShape
import java.awt.*;

public abstract class Shape {
  int initX, initY;
  Color fillColour;

  public Shape() {
    initX = 0;
    initY = 0;
  }

  public Shape(int x, int y) {
    initX = x;
    initY = y;
  }

  public void setInitX (int x) {
    initX = x;
  }

  public void setInitY (int y) {
    initY = y;
  }

  public abstract void draw(Graphics g);
  public abstract double Area();
  public abstract double Perimeter();

  public void Move(int deltaX, int deltaY){
    initX = initX+deltaX;
    initY = initY+deltaY;
  }
}
