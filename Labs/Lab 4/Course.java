import java.util.*;
public class Course implements EnrollmentList{
    // set this class to implement the EnrollmentList interface.
    // Add instance variables needed to this class.
        private Person [] list;
        private String courseName;
        private int count;
    public Course(String courseName, int size){
        // FILL IN THE CONSTRUCTOR
        this.courseName = courseName;
        list = new Person[size];
        count = 0;
    }
    //Getters
    public String getCourseName(){
        return courseName;
    }
    //Setters
    public void setCourseName(String courseName){
        this.courseName=courseName;
    }

    public void addPerson(Person addition){
        list[count]= addition;
        count++;
    }

    public void removePerson(String name){
        for(int i=0;i<count;i++){
            if( name.equals(list[i].getName()) ){
                count--;
                list[i]=list[count];
                break;
            }
        }
    }

    public Person find(String name){
        for(int i=0;i<count;i++){
            if(name.equals(list[i].getName())){
                return list[i];
            }
        }
        return null;
    }

    public String listStudents(){
        String retStr = courseName+ " Student List\n";
        for(int i =0;i<count;i++){
            if (list[i] instanceof Student){
                retStr+=list[i].toString()+"\n";
            }
        }
        return retStr;
    }

    public String listTAs(){
        String retStr = courseName+ " TA List\n";
        for(int i =0;i<count;i++){
            if (list[i] instanceof TA){
                retStr+=list[i].toString()+"\n";
            }
        }
        return retStr;
    }

    public void sort(){
        Arrays.sort(list,0,count);
    }

    public String toString(){
        String retStr = courseName+ " Class List\n";
        for(int i =0;i<count;i++){
            retStr+=list[i].toString()+"\n";
        }
        return retStr;
    }

    public static void main(String[] args){

        // TESTING CODE
        // Feel free to uncomment this code and use it to test your final implementation.
        EnrollmentList csc115 = new Course("CSC 115", 300);

        csc115.addPerson(new Student("Mr. T", "t@ateam.com", 5456, 100));
        csc115.addPerson(new Student("Hannibal", "master_plan@ateam.com", 15456, 62));
        csc115.addPerson(new Student("Murdoch", "crazy@ateam.com", 5454356, 26));
        csc115.addPerson(new Student("Face", "face@ateam.com", 343284, 37));
        csc115.addPerson(new TA("Kenobi", "obiwan@theforce.com", 213423, 700, 43243));
        csc115.addPerson(new Student("Boba", "retcon@bounty.com", 543231, 72));
        csc115.addPerson(new TA("Ackbar", "trap@rebels.com", 43554, 10000, 21234));
        csc115.addPerson(new Student("Lando", "scoundrel@cloudcity.com", 4343, 93));

        System.out.println(csc115);

        System.out.println("Find Face: " + csc115.find("Face"));
        csc115.removePerson("Face");

        System.out.println("Remove Face.");
        System.out.println("Find Face: " + csc115.find("Face")+"\n");

        System.out.println("Sorting list.\n");
        csc115.sort();

        System.out.println(csc115);
        System.out.println(csc115.listStudents());
        System.out.println(csc115.listTAs());

    }
}