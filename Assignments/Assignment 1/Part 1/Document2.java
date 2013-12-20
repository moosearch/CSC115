/*
Wesley Chow
CSC 115
Assignment 1 (Milestone)
Due September 14, 2012
Calculates GPA for students in a particular format
*/

import java.io.*;
import java.util.*;


public class Document2{

    public static void initialisation(Scanner input,String [] letterGrades,double [] studentGPA){ //starts the scanning of the file

        int gpaArraytrack = 0; //used for indexing the array, "studentGPA"

        //initialises variables for scanning each student and getting gpa
        String name1 = ""; //surname
        String name2 = ""; //first name
        String idNumber = "";
        int numberOfTerms = 0; //since there are 5 courses/term, can simply multiply by this number later for total courses
        double gpaValue = 0;
        int mrcounter = 0;
        while(input.hasNext()){
                //student name and id
                name1 = input.next();
                name2 = input.next();
                idNumber = input.next();
                System.out.print(name1+" "+name2+" "+"("+idNumber+").");
                numberOfTerms = input.nextInt();
                gpaValue= letterCollector(numberOfTerms,input,letterGrades); //go to method for getting letter grades
                studentGPA[gpaArraytrack]=gpaValue; //add GPA to studentGPA array
                gpaArraytrack++;
                System.out.print(" GPA: "+gpaValue+"\n");
        }//end of while

    }//end of initialisation

    public static double letterCollector(int Terms, Scanner input,String [] letterGrades){ //inputs letter grades into array, then calls another method for gpa conversion

        int inputCounter = 0;
        int arraySpot = 0;
        while(arraySpot!=Terms*5){ //will fill array until the number of courses is reached
            input.next(); //garbage
            letterGrades[arraySpot]=input.next();;
            arraySpot++;
        }
        //System.out.println(Arrays.toString(letterGrades));
        double GPA = letterGPA(Terms*5,letterGrades); //goes to calculate gpa, Terms*5 is the number of courses.
        return GPA;

    }//end of letterCollector

    public static double letterGPA(int number,String [] letterGrades){ //converts letter grades into points, then calculates gpa
        //"number" is the total number of courses taken by the student
        boolean dummy = true;
        String [] letters = {"A+","A","A-","B+","B","B-","C+","C","D","F"}; //initialise variables to compare
        double [] valueOfGrade = {9,8,7,6,5,4,3,2,1,0}; //value of equivalent letter grades in same order
        double sum = 0;
        for(int i = 0; i<number; i++){
            int j = 0;
            while(letterGrades[i].equals(letters[j])!=dummy){
                j++;
            }
            sum += valueOfGrade[j]; //repeats until it finds a matching letter grade, then added to this sum
        }
        double GPA = sum/(number); //since course weight is the same, can simplify to this as opposed to sum*1.5/(number*1.5)
        return GPA;

    }//end of letterGPA

    public static void main(String [] args) throws FileNotFoundException{
        //set up scanner for file input
        File data = new File("Data.txt");
        Scanner input = new Scanner(data);
        String [] letterGrades = new String[50]; //arbitrarily large array for storing letter grades
        double [] studentGPA = new double[50]; //arbitrarily large array for storing gpa grades
        initialisation(input,letterGrades,studentGPA);
        System.out.println();

    }//end of main

}