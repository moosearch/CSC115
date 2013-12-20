import java.util.*;
import java.io.*;
public class CodeLab2{

    public static void main(String [] args) throws FileNotFoundException{

        //Exercise 1########################################
        /*Scanner input = new Scanner (System.in);
        System.out.print("What is your name? ");
        String name = input.next();
        System.out.println("Hello " + name + "..!");*/

        //Exercise 2########################################
        //part 1
        /*if(args.length >0){
            System.out.println(args[0]);
        }
        //part 2
        int firstArg;
        if (args.length > 0) {
            try {
                firstArg = Integer.parseInt(args[0]);
                for(int i = 1; i<=firstArg;i++){
                    System.out.println(i);
                }
            } catch (NumberFormatException e) {
                System.err.println("Argument" + " must be an integer");
                System.exit(1);
            }
        }
        if(args.length>0){
            System.out.println("Hi, my name is "+args[0]);
        }*/

        //Exercise 3#########################################

        Scanner s = new Scanner(new BufferedReader(new FileReader("inFile.txt")));
        while(s.hasNext()){
            System.out.println(s.next());
        }

    }//end of main

}//end of class