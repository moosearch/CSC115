//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Superclass for closed shapes
import java.awt.Graphics;

public abstract class ClosedShape extends Shape {
  boolean polygon;
  int numPoints;
  int[] xVertices;
  int[] yVertices;
  int x,y,width, height;

  public ClosedShape(boolean isPolygon, int numPoints) {
    super(0,0);
    this.polygon = isPolygon;
    this.numPoints = numPoints;
  }

  public ClosedShape(boolean isPolygon, int numPoints, int[] x, int[] y) {
    super(x[0],y[0]);
    this.polygon = isPolygon;
    if (isPolygon) {
      this.numPoints = numPoints;
      xVertices = new int[numPoints]; // error check?  if x.length == numPoints
      for (int i = 0; i < x.length; i++) { // make copy of array: why?
        xVertices[i] = x[i];
      }
      yVertices = new int[numPoints]; // error check?  if y.length == numPoints
      for (int i = 0; i < y.length; i++) { // make copy of array
          yVertices[i] = y[i];
      }
    }
    else { // its an oval - define bounding box
      this.numPoints = 4;
      this.x = x[0];
      this.y = y[0];
      width = x[1];
      height = y[1];
    }
  }

  public void setXYCoords(int[] x, int[] y){
    this.xVertices = x;
    this.yVertices = y;
  }

  // Gives access to the width attribute
  public void setWidth(int width){
    //write me
    this.width = width;
  }

  // Gives access to the height attribute
  public void setHeight(int height){
    //write me
    this.height = height;
  }

  public void draw(Graphics g){
    if (polygon) {
      g.drawPolygon(xVertices, yVertices, numPoints);
    }
    else {
      g.drawOval(x, y, width, height);
    }

  }

  public abstract double Area();
  public abstract double Perimeter();


}