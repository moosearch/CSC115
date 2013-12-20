//Wesley Chow
//Assignment 5
//Due November 30, 2012
//Class Tree
public class Tree extends Compound{

    public Tree(int x,int y,int width,int height){
        //oval will sit on top of the trunk
        Rectangle trunk = new Rectangle(x,y,width,height);
        Oval treeTop = new Oval(x+width/2,y+height/2,width,height);
    }

}