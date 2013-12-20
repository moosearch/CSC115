public class LLStack implements Stack{// set LLStack so that it implements the Stack interface
    private Node head;
    public LLStack(){
        // FILL IN THE CONSTRUCTOR
        head = null;
    }

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

    public void push(Object item){
        Node n = new Node(item); //initialise node
        n.setNext(head); //point to the head of the list (ie. top of the list)
        head = n; //set head so that it's pointing to the new item

    }

    public Object peek(){
        if(isEmpty()==true){
            System.out.println("**ERROR: The list is empty. No items to peek at.**");
            return null;
        }
        return head.getData();
    }

    public boolean isEmpty(){
        if(head==null){
            return true;
        }else{
            return false;
        }
    }

    public Object pop(){
        if(isEmpty()==true){
            System.out.println("**ERROR: The list is empty, no items were popped.**");
            return null;
        }
        Object temp = head.getData(); //set temp = data that's being removed
        head=head.getNext(); //move head to next item.
        return temp;
    }

    public static void main(String[] args){
        //Uncomment this section to test adding to the stack.
        Stack testStack = new LLStack();
        testStack.push("first item");
        testStack.push("second item");
        testStack.push("third item");
        System.out.println(testStack);


        //Uncomment this section to test peeking at the top value.
        System.out.println("Top item is " + testStack.peek());


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
        //*/
        testStack.pop();
    }
}