import java.util.*;
public class Lab1Code{

    public static void main(String [] args){
        //part1
        basicJavaPrograms();
        //part2
        printingLoops();
        //part 3
        int [] x = {3,5,7,2,8,5,3,6};
        int [] y = new int[x.length];
        arrays(x,y);
        //part 4(use x for parameter)
        int number = 1;
        System.out.println(methods(number,x));
    }

    public static void basicJavaPrograms(){
        System.out.println("Hello world");
        String name1 = "Wilson";
        String name2 = "Chang";
        int random = 69;
        System.out.println(name1+name2+random);
    }

    public static void printingLoops(){
        for(int i=0;i<10;i++){
            System.out.print((i+1)+" ");
        }
        System.out.println();
        for(int i=0;i<10;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void arrays(int [] x,int [] y){
        int [] tester = new int[10];
        for(int i=0;i<tester.length;i++){
            tester[i]=(i+1);
        }
        System.out.println("Array contents: "+Arrays.toString(tester));

        //print values divisible by 3 or 5
        System.out.print("Numbers divisible by 3 or 5 in that array: ");
        for(int i=0;i<tester.length;i++){
            if(tester[i]%3==0 || tester[i]%5==0){
                System.out.print(tester[i]+" ");
            }
        }
        System.out.println();

        //copying contents of x into y backwards
        for(int i=0;i<x.length;i++){
            y[y.length-i-1]=x[i];
        }
        System.out.println("Contents of Array x: "+Arrays.toString(x));
        System.out.println("Contents of Array y: "+Arrays.toString(y));
    }

    public static int methods(int x, int [] y){
        int counter = 0;
        for(int i=0;i<y.length;i++){

            if(10%y[i]==0){
                counter++;
            }

        }
        return counter;
    }

}