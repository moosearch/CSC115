import java.util.*;
public class LinkedStack<T> implements Stack<T>{
    private Node<T> head;
    private int stackCounter;

    //constructor #1: stack w/ 1 item
    public LinkedStack(T item1){
        Node<T> stack = new Node<T>(item1);
        head=stack;
        stackCounter++;
    }

    //constructor #2: empty stack
    public LinkedStack(){
        head=null;
    }

    //adds item on top of stack
    public void push(T item){
        Node<T> n = new Node<T>(item); //initialise node
        n.setNext(head); //point to the head of the list (ie. top of the list)
        head = n; //set head so that it's pointing to the new item
        stackCounter++;
    }

    //removes item from top of stack
    public T pop(){
        try{
            T item = head.getData();
            head = head.getNext();
            stackCounter--;
            return item;
        }catch (NullPointerException e){
            System.out.println("**ERROR: Nothing to pop from the stack!**");
            return null;
        }
    }

    //peek method: checks top item of stack
    public T top(){
        return head.getData();
    }

    //checks if stack is empty
    public boolean isEmpty(){
        if(head==null){
            return true;
        }else{
            return false;
        }
    }

    //tostring method - self explanatory
    public String toString(){
        // FILL IN THIS METHOD
        if(head==null){
            return "**ERROR: No data to print out.**";
        }
        String retStr = "";
        Node current = head;
            while(current!=null){
                retStr += current.getData()+"\n"; //just adding "current" or "current.toString()" works too
                current = current.getNext();
            }
        return retStr;
    }


    //tester program
    public static void main(String [] args){
        //Uncomment this section to test adding to the stack.
        LinkedStack<String> testStack = new LinkedStack<String>();
        System.out.println(testStack.toString());
        testStack.push("first item");
        testStack.push("second item");
        testStack.push("third item");
        System.out.println(testStack);


        //Uncomment this section to test peeking at the top value.
        System.out.println("Top item is " + testStack.top());


        //Uncomment this section to test the isEmpty method.
        System.out.println("Is the stack empty? " + testStack.isEmpty());


        //Uncomment this section to test removing from the stack.
        testStack.pop();
        testStack.pop();
        testStack.push("fourth item");

        System.out.println("Contents of the stack after popping two items and adding a fourth: " + testStack);
        testStack.pop();
        testStack.pop();
        System.out.println("Is the stack empty after popping two more times? " + testStack.isEmpty());

        testStack.pop();
    }

}