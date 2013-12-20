import java.io.*;
import java.util.Scanner;

public class Document4{

    public static void main(String [] args) throws FileNotFoundException{
        File yeah = new File("test.txt");
        Scanner input = new Scanner(yeah);

            String [] gangster = {"B+",
            "C+",
            "C",
            "B+",
            "B",
            "B",
            "C",
            "B+",
            "B-",
            "B",
            "C",
            "D",
            "B",
            "B+",
            "C"};


        int number=15;
        String [] letters = {"A+","A","A-","B+","B","B-","C+","C","D","F"};
        double [] valueOfGrade = {9,8,7,6,5,4,3,2,1,0};
        double sum = 0;
        for(int i = 0; i<number; i++){
            int j = 0;
            while(gangster[i]!=letters[j]){

                j++;
            }
            System.out.println(letters[j]);
            sum += valueOfGrade[j];
        }


    }


}