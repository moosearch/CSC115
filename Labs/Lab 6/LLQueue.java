import java.util.*;

public class LLQueue{ // set this class to implement the Queue interface
    // We need to keep track of both ends of the queue, we accomplish this in a linked list
    // by storing head and tail references.
    private Node head;
    private Node tail;

    public LLQueue(){
        // FILL IN THE CONSTRUCTOR
        head = null;
        tail = null;
    }

    public String toString(){
        // FILL IN THIS METHOD
        String retStr = "";
        Node current = head;

        while(current!=null){
            retStr += current.getData()+"\n"; //just adding "current" or "current.toString()" works too
            current = current.getNext();
        }

        return retStr;
    }

    // Adds the specified item at the end of the queue.
    public void enqueue(Object item){
        Node n = new Node(item);
        if(head==null){
            head = n;
            tail = n;
        }else{
            tail.setNext(n); //1
            tail=n; //2
        }
    }

    // Returns the item at the front of the queue.
    public Object peek(){
        try{
            return head.getData();
        }catch (NullPointerException e){
            String error="**ERROR: No items to peek at.**";
            System.out.println(error);
            return null;
        }
    }

    // Returns true if the queue is empty, false otherwise.
    public boolean isEmpty(){
        if(head==null){
            return true;
        }else{
            return false;
        }
    }

    // Returns and removes the front item of the queue.
    public Object dequeue(){
        Node n=head;
        head = head.getNext();
        if(head==null){ //case where we go from n=1 items to n=0 items
            tail=null;
        }
        return n.getData();
    }

    public static void main(String[] args){
        //Uncomment this section to test adding to the queue.
        LLQueue testQueue = new LLQueue();
        testQueue.enqueue("first item");
        testQueue.enqueue("second item");
        testQueue.enqueue("third item");
        System.out.println(testQueue);


        //Uncomment** this section to test peeking at the queue.
        System.out.println("First item is " + testQueue.peek());


        //Uncomment this section to test the isEmpty method.
        System.out.println("Is the queue empty? " + testQueue.isEmpty());


        //Uncomment this section to test removing from the queue.
        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.enqueue("fourth item");
        System.out.println("Contents of the queue after dequeueing two items and enqueueing a fourth item: " + testQueue);
        testQueue.dequeue();
        testQueue.dequeue();
        System.out.println("Is the queue empty after dequeueing two more times? " + testQueue.isEmpty());
        //*/
        testQueue.peek();
    }
}