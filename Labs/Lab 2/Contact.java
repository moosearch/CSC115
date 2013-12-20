import java.io.*;
import java.util.*;

public class Contact{
    //initialise instance variables, accessable to everything
    //in the class, but nothing outside of the class
    private String name;
    private String phone;
    private String email;

    //default constructor
    public Contact(){
        this.name="";
        this.phone="";
        this.email="";
    }

    //constructor
    public Contact(String name, String phone, String email){
        this.name=name;
        this.phone=phone;
        this.email=email;
    }

    //class methods

    //setter methods
    /*public void setName(String newName){
        this.name=newName;
    }

    public void setPhone(String newPhone){
        this.phone=newPhone;
    }

    public void setEmail(String newEmail){
        this.email=newEmail;
    }*/

    //getter methods
    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }


    //toString method

    public String toString(){
        String result = name+" "+phone+" "+email;
        return result;
    }

    //main method for testing
    public static void main(String [] args){
        Scanner stdin = new Scanner(System.in);
        Contact test = new Contact("Mike","12345a67","foo@bar.com");
        System.out.println(test.getName());
        System.out.println(test.getPhone());
        System.out.println(test.getEmail());
        System.out.println(test);
    }

}








//Designing a car class


/*class car
 - string colour
 - string model
 - int mileage
 - double topspeed
 - void paintjob()
 - int fillGas (cost of gas)
 - boolean turboBoost (whether we can get it or not)

*/