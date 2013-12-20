/*
Wesley Chow
CSC 115
Assignment 1 (Milestone)
Due September 14, 2012
Calculates GPA for students
*/

import java.io.*;
import java.util.Scanner;

public class GPACalculator{


    public static double valueOfGrade(String [] grades){
        String [] letters = {"A+","A","A-","B+","B","B-","C+","C","D","F"};
        int [] valueOfGrade = {9,8,7,6,5,4,3,2,1,0};
        int j = 0;
        double sum = 0;
        boolean dummy = true;
        for(int i = 0; i<letters.length;i++){
            while(grades[i].equals(letters[j])!=dummy){
                j++;
            }
            sum+= valueOfGrade[j];
            j=0;
        }
        sum/=(double)grades.length;
        return sum;
    }

    public static double fillGrades(int Terms,Scanner gradeInput){
        String [] gradeStorage = new String[Terms*5];
        int i = 0;
        String garbage = "";
        while(gradeInput.hasNext()){
            String xyz = gradeInput.next();
            if(xyz.length()<=2){
                gradeStorage[i] = gradeInput.next();
            }
            i++;
            if(i>Terms*5-1){
                break;
            }
        }
        double gpaValue = valueOfGrade(gradeStorage);
        return gpaValue;
    }

    public static void main(String [] args) throws FileNotFoundException{
        //set up scanner for file input

        File data = new File("Data.txt");
        Scanner input = new Scanner(data);

        String name = "";
        String idNumber = "";
        int numberOfTerms = 0;
        double gpaValue=0;
        //time to scan file
        while(input.hasNext()){
                //student name and id
                name = input.nextLine();
                idNumber = input.next();
                System.out.println(name+" "+"("+idNumber+")");
                numberOfTerms = input.nextInt();
                System.out.println(numberOfTerms);
                gpaValue= fillGrades(numberOfTerms,input);
                //System.out.println(gpaValue);
        }
        System.out.println("done");
    }//end of main

}