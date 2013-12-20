import java.util.*;
public class CourseLL implements EnrollmentList{
    // Instance variables.
    private Node head;
    private int classSize;
    private String name;

    public CourseLL(String courseName){
        // FILL IN THE CONSTRUCTOR.
        name = courseName;
        classSize=0;
        head=null;
    }

    /**
     * Adds a person to the front of the list.
     * @param the person being added to the list
     */
    public void addPerson(Person newData){
        // FILL IN THIS METHOD
        Node nn = new Node(newData);
        //make sure that nn is pointing to first node (if any)
        nn.setNext(head);
        head=nn;
        classSize++;
    }

    public String toString(){
        // FILL IN THIS METHOD
        String list = "";
        list+="List Name: "+name+"\n";
        list+="List Size: "+classSize+"\n";
        Node current = head;
        while(current!=null){
            list += current.toString()+"\n";
            current = current.getNext();
        }
        return list;
        //return head.toString();
        //return "";
    }

    /**
     * Removes the first person with the specified name from the list.
     * Remember to use the .equals method when comparing two String variables
     * to see if they contain the same characters.
     * @param the name of the person to be removed from the list.
     */
    public void removePerson(String name){
        // FILL IN THIS METHOD
        if(head==null)
            return;
        //method 1
        /*Person p = head.getData();
        String n = p.getName();
        if(n.equals(name)){

        }*/

        //or method 2
        //(1.2.3) 1 is the person, 2 is the name, 3 is the equals method comparison
        if(head.getData().getName().equals(name)){
            Node temp = head;
            head=head.getNext();
            temp.setNext(null);
            classSize--;
            return;
        }

        //if node is not the first one
        Node current = head;
        Node prev = head;
        while(current != null){
            if(current.getData().getName().equals(name)){
                //delete
                prev.setNext(current.getNext());
                //decrease size
                classSize--;
                //exit loop
                return;
            }else{
                //go to next node
                prev=current;
                //prev=prev.getNext();
                current = current.getNext();
            }
        }
    }

    /**
     * Returns the first person in the list with the specified name.
     * Remember to use the .equals method when comparing two String variables
     * to see if they contain the same characters.
     * @param the name of the person to find in the list.
     * @return the Person with the specified name, or null if there is
     * no such Person in the list.
     */
    public Person find(String name){
        Node currentNode = head;

        for (int i = 0; i < classSize; i++){
            if (name.equals(currentNode.getData().getName())){
                return currentNode.getData();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     * Return all Students in the list as a String.
     * Note that you can check the class of an object using the instanceof command, like so:
     * if (object instanceof Student)
     * @return a String containing the printable form of all students in the list.
     */
    public String listStudents(){
        String result = name + " Student list: \n";
        Node currentNode = head;
        for (int i = 0; i < classSize; i++){
            if (currentNode.getData() instanceof Student){
                result += currentNode.toString() + "\n";
            }

            currentNode = currentNode.getNext();
        }
        return result;
    }

    /**
     * Return all Employees in the list as a String.
     * Note that you can check the class of an object using the instanceof command, similar
     * to listStudents().
     * @return a String containing the printable form of all employees in the list.
     */
    public String listTAs(){
        String result = name + " TAs list: \n";
        Node currentNode = head;
        for (int i = 0; i < classSize; i++){
            if (currentNode.getData() instanceof TA){
                result += currentNode.toString() + "\n";
            }
            currentNode = currentNode.getNext();
        }
        return result;
    }

    public static void main(String[] args){

        // TESTING CODE
        // Feel free to uncomment this code and use it to test your final implementation.
        // NOTE: This testing code is almost identical to the code used to test Course.java
        // in Lab 4.  By using an interface, we can switch implementations easily with
        // only changing a single line of code in the tester program.

        EnrollmentList csc115 = new CourseLL("CSC 115");

        csc115.addPerson(new Student("Mr. T", "t@ateam.com", 5456, 100));
        csc115.addPerson(new Student("Hannibal", "master_plan@ateam.com", 15456, 62));
        csc115.addPerson(new Student("Murdoch", "crazy@ateam.com", 5454356, 26));
        csc115.addPerson(new Student("Face", "face@ateam.com", 343284, 37));

        csc115.addPerson(new Student("Luke", "luke@skywalker.com", 999956, 86));
        csc115.addPerson(new TA("Kenobi", "obiwan@theforce.com", 213423, 700, 43243));
        csc115.addPerson(new Student("Boba", "retcon@bounty.com", 543231, 72));
        csc115.addPerson(new TA("Ackbar", "trap@rebels.com", 43554, 10000, 21234));
        csc115.addPerson(new Student("Lando", "scoundrel@cloudcity.com", 4343, 93));

        System.out.println(csc115);

        System.out.println("Find Luke: " + csc115.find("Luke") + "\n");

        System.out.println(csc115.listStudents());
        System.out.println(csc115.listTAs());

        System.out.println("Remove Luke.");
        csc115.removePerson("Luke");
        System.out.println("Find Luke: " + csc115.find("Luke")+"\n");

        System.out.println("Remove Lando.");
        csc115.removePerson("Lando");
        System.out.println("Find Lando: " + csc115.find("Lando")+"\n");

        System.out.println("Remove Jeremy.");
        csc115.removePerson("Jeremy");
        System.out.println("Find Jeremy: " + csc115.find("Jeremy")+"\n");

        System.out.println(csc115);

    }
}