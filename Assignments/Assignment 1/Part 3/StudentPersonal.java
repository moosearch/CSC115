//Wesley Chow (V00727646)
//CSC 115 (A01)
//Assignment 2 Part 3
//Due September 21, 2012 @ 1530 hours
//Title: Personal Information Storer
/*Program Description: This is an object class that stores and maintains personal information of a university student.
Includes basic constructors, setter, getter, and toString methods. Also has a method to check for same student*/


public class StudentPersonal{

    private String name;
    private String idNumber; //set as string to ensure if the id number starts with 0 that the 0 does not get parsed
    private String birthdate; //set as string for the same reason as the idNumber
    private String address;
    private String city;
    private String province;
    private String country;
    private String postalCode;
    private String email;
    private String emergencyContact;
    private String emergencyContactNumber;

    //default constructor
    StudentPersonal(){
        this.name = "";
        this.idNumber = "";
        this.birthdate = "";
        this.address = "";
        this.province = "";
        this.country = "";
        this.postalCode = "";
        this.city = "";
        this.email = "";
        this.emergencyContact = "";
        this.emergencyContactNumber = "";
    }

    StudentPersonal(String name,String idNumber,String birthdate){
        this.name = name;
        this.idNumber = idNumber;
        this.birthdate = birthdate;
    }

    //constructor for all attributes
    StudentPersonal(String name,String idNumber,String birthdate,String address,String city,String province,String country,
    String postalCode,String email,String emergencyContact,String emergencyContactNumber){
        this.name = name;
        this.idNumber = idNumber;
        this.birthdate = birthdate;
        this.address = address;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
        this.emergencyContact = emergencyContact;
        this.emergencyContactNumber = emergencyContactNumber;
    }

    //setter methods

    public void setName(String name){
        this.name=name;
    }

    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    public void setBirthdate(String birthdate){
        this.birthdate = birthdate;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setProvince(String province){
        this.province = province;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setEmergencyContact(String emergencyContact){
        this.emergencyContact = emergencyContact;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber){
        this.emergencyContactNumber = emergencyContactNumber;
    }

    //getter methods

    public String getName(){
        return this.name;
    }

    public String getIdNumber(){
        return this.idNumber;
    }

    public String getBirthdate(){
        return this.birthdate;
    }

    public String getAddress(){
        return this.address;
    }

    public String getCity(){
        return this.city;
    }

    public String getProvince(){
        return this.province;
    }

    public String getCountry(){
        return this.country;
    }

    public String getPostalCode(){
        return this.postalCode;
    }

    public String getEmail(){
        return this.email;
    }

    public String getEmergencyContact(){
        return this.emergencyContact;
    }

    public String getEmergencyContactNumber(){
        return this.emergencyContactNumber;
    }

    public boolean equals(StudentPersonal otherGuy){
        if(otherGuy.name.equals(this.name) && otherGuy.idNumber.equals(this.idNumber) &&
        otherGuy.birthdate.equals(this.birthdate)){
            return true;
        }
        return false;
    }

    public String toString(/*String name,String idNumber,String birthdate, String address,
    String city,String province,String country,String postalCode,String email,
    String emergencyContact,String emergencyContactNumber*/){
        String result ="";
        result="Name: " + this.name + "\nID Number: " + this.idNumber + "\nBirthdate: " + this.birthdate + "\nAddress: " + this.address +
        "\nCity: " + this.city + "\nProvince: " + this.province + "\nCountry: " + this.country + "\nPostal Code: " + this.postalCode +
        "\nEmail: " + this.email + "\nEmergency Contact: " + this.emergencyContact + "\nEmergency Contact's Number: " + this.emergencyContactNumber;
        return result;
    }



    public static void main(String [] args){

        StudentPersonal [] storage = new StudentPersonal[2];
        storage[0] = new StudentPersonal("Mojo","12345","1992-01-01");
        storage[1] = new StudentPersonal("Mojo","12345","1992-01-01");
        //storage[0].name="Your mojo";
        System.out.println(storage[0].getName());
        boolean tester = storage[0].equals(storage[1]);
        System.out.println(tester);
        System.out.println(storage[0].toString());

    }
}