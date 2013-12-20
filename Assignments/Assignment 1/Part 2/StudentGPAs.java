//Wesley Chow (V00727646)
//CSC 115 (A01)
//Assignment 2 Part 2
//Due September 21, 2012 @ 1530 hours
//Title: GPA Calculator (for multiple students)
/*Program Description: This program calculates the cumulative GPA of students from a text file using the Student class methods.
It is assumed that the student has consecutively taken 5 courses every term.*/

import java.io.*;
import java.util.*;
public class StudentGPAs{


    /*this method checks if the person has been processed before; if the student has, then nothing gets printed and "arraySpot"
    (current spot number in the studentList) gets decreased by 1. If the student hasn't, the else statement activates*/
    public static int printResults(String name,long id,int arraySpot,Student [] studentList){
            //check if the person has been
            boolean samePerson = idCheck(name,id,arraySpot,studentList);
            if(samePerson!=false){
                /*this will set up the next student after the current
                in the data to have their data overwrite this repeat student's data*/
                System.out.println("The student "+studentList[arraySpot].getName()+" has been already processed before.\n");
                arraySpot--;
            }else{
            System.out.println(studentList[arraySpot].toString());
            double totalGPA = studentList[arraySpot].getCumulativeGPA();
            System.out.println("Cumulative GPA for "+studentList[arraySpot].getName()+": "+totalGPA+"\n\n");
            }
            return arraySpot;
    }//end of printResults


    //this method transverses arrays for courses and grades
    public static void arrayFill(String [][] courses,String [][] letterGrades, Scanner stdin){
        for(int i = 0; i<courses.length; i++){
            for(int j = 0; j<courses[i].length;j++){
                courses[i][j] = stdin.next();
                letterGrades[i][j] = stdin.next();
            }
        }
    }//end of arrayFill


    //this method checks to see if the current person being processed has been processed before
    public static boolean idCheck(String name, long id, int spotNumber,Student [] studentList){
        boolean test = false;
        //loop through all the students in the studentList array
        for(int i = 0;i<spotNumber;i++){
            test = studentList[spotNumber].equals(studentList[i]);
            if(test==true)
                break;
        }
        return test;
    }//end of idCheck


    //introduced the name,id,coursenames,lettergrades, and processed them
    public static void main(String [] args) throws FileNotFoundException{

        //create scanner
        File data = new File("Data.txt");
        Scanner stdin = new Scanner(data);
        int numberOfStudents = stdin.nextInt(); //number of students in text file
        Student [] studentList = new Student[numberOfStudents];
        for(int arraySpot = 0;arraySpot<studentList.length;arraySpot++){
            //get surname, name, then concatenate
            String name1 = stdin.next();
            String name2 = stdin.next();
            String name = name1+" "+name2;
            long id = stdin.nextLong();
            int termsDone = stdin.nextInt();
            //create arrays for course names and letter grades and transverse each of them
            String [][] courseNames = new String[termsDone][5];
            String [][] gradeLetter = new String[termsDone][5];
            arrayFill(courseNames,gradeLetter,stdin);
            //create a new student object in studentList the spot number "arraySpot" with parameters predefined
            studentList[arraySpot] = new Student(name,id,courseNames,gradeLetter);
            int newArraySpot = printResults(name,id,arraySpot,studentList); //prints results if it is a unique person
        }

    }//end of main

}
