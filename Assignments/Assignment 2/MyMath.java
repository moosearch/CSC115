//Wesley Chow (V00727646)
//CSC 115 (A01)
//Assignment 2
//Due October 5, 2012 @ 1530 hours
//Title: MyMath class
/*Program Description: Class for calculating x^n, n!, and
approximating sine with the use of iterative/recursive methods*/


import java.util.*;
public class MyMath{

    //attributes
    private double x;
    private long n;

    //constructor
    MyMath(double base,long power){
        this.x=base;
        if(power>=0){
            this.n=power;
        }else{
            System.out.println("Not a valid number");
        }
    }

    //getter
    public double getx(){
        return this.x;
    }
    public long getn(){
        return this.n;
    }

    //setter
    public void setx(double base){
        this.x=base;
    }
    public void setn(long power){
        if(power>=0){
            this.n=power;
        }else{
            System.out.println("Invalid input for exponent, enter a number >=0.");
        }
    }

    //equals method
    public boolean equals(MyMath other){
        boolean sameAnswer = false;
        if(this.x==other.x && this.n==other.n){
            sameAnswer = true;
        }
        return sameAnswer;
    }

    ////toString method, returns a string that has all the results using the methods
    public String toString(){
        String result = "";
        result+="iterative x^n answer: "+iterativeXN(this.x,this.n)+"\n";
        result+="recursive x^n answer (#1): "+recursiveXN1(this.x,this.n)+"\n";
        result+="recursive x^n answer (#2): "+recursiveXN2(this.x,this.n)+"\n";
        result+="iterative x! answer: "+iterativeFact(this.x)+"\n";
        result+="recursive x! answer: "+recursiveFact(this.x)+"\n";
        result+="iterative sinx approx. answer: "+iterativeTaylorSeries(this.x, this.n)+"\n";
        result+="recursive sinx approx. answer (#1): "+recursiveTaylorSeries1(this.x,this.n)+"\n";
        result+="recursive sinx approx. answer (#2): "+recursiveTaylorSeries2(this.x,this.n);
        return result;
    }

    //check if a number if negative or not
    private boolean negativeCheck(long number){
        if(number < 0){
            System.out.println("One of your values are negative");
            return true;
        }
        else{
            return false;
        }
    }

    //iterative method for calculating x^n
    public double iterativeXN(double x,long n){
        //check is n is negative
        if(negativeCheck(n) == true)
            return 0;
        //base case
        if(n==0){
            return 1;
        }
        //loop and keep product tally
        double product=1;
        for(int i=0;i<n;i++){
            product *= x;
        }
        return product;
    }

    //1st recursive method for calculating x^n
    public double recursiveXN1(double x,long n){
        //check is n is negative
        if(negativeCheck(n) == true)
            return 0;
        if(n==0){
            return 1;
        }else{
            return x*recursiveXN1(x,n-1);
        }
    }

    //2nd recursive method for calculating x^n
    public double recursiveXN2(double x,long n){
        //check is n is negative
        if(negativeCheck(n) == true)
            return 0;
        if(n==0){
            return 1;
        }else if(n%2==0){
            return recursiveXN2(x*x,n/2);
        }else{
            return x*recursiveXN2(x*x,n/2);
        }
    }

    //iterative method for calculating x!
    public double iterativeFact(double x){
        //check is n is negative
        if(negativeCheck((long)x) == true){
            return 0;
        }else if(x==0 || x==1){
            return 1;
        }else{
            double product=1;
                for(int i=0;i<x;i++){
                    product*=(i+1);
                }
            return product;
        }
    }

    //recursive method for calculating x!
    public double recursiveFact(double x){
        //check is n is negative
        if(negativeCheck((long)x) == true){
            return 0;
        }else if(x==1 || x==0){ //base case
            return 1;
        }else{
            return x*recursiveFact(x-1);
        }
    }

    //iterative method for approximating sine w/ the series
    public double iterativeTaylorSeries(double x,long n){
        double sum=0.0;
        //check is n is negative
        if(negativeCheck(n) == true){
            return 0;
        }
        for(int i=0;i<(n+1);i++){
            if(i%2==0){//if n is even
                sum+=recursiveXN2(x,2*i+1)/recursiveFact(2*i+1);
            }else{//if n is odd
                sum-=recursiveXN2(x,2*i+1)/recursiveFact(2*i+1);
            }
        }
        return sum;
    }

    //recursive method for approximating sine w/ the series
    public double recursiveTaylorSeries1(double x, long n){
        //check is n is negative
        if(negativeCheck(n) == true){
            return 0;
        }else if(n==0){ //base case
            return x;
        }else{
            //the 5 lines check if the term is odd or even
            int neg1powerN;
            if(n%2==0){
                neg1powerN=1;
            }else{
                neg1powerN=-1;
            }
            return recursiveTaylorSeries1(x,n-1)+neg1powerN
            *recursiveXN2(x,2*n+1)/recursiveFact(2*n+1); //actual recursive call
        }
    }

    public double recursiveTaylorSeries2(double x, long n){
        if(n==0){ //base case
            return x;
        }else{
            //return 1-recursiveTaylorSeries2(x,n-1);
            return recursiveTaylorSeries2(x,n-1)*(1-(x*x/(4*n*n+2*n)));
        }
    }

    public static void main(String [] args){

        double x= 1;
        long n = 3;
        MyMath tester = new MyMath(x,n);
        System.out.println(tester.iterativeTaylorSeries(x,n));
        System.out.println(tester.recursiveTaylorSeries1(x,n));
        System.out.println(tester.recursiveTaylorSeries2(x,n));
    }//end of main

}//end of class