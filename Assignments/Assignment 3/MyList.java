//Student Name: Wesley Chow
//Student Number: V00727646
//CSC 115 Java section
//Due Oct 19, 2012 @ 4PM
/*Basic linked list with only one node head and subsequent nodes, no tail*/

public class MyList{

  private Node head;

  public MyList(){
      head = null;
      /*Postcondition: an empty list is initialized */
  }

  public void addHead(char newValue){
      //Precondition: the lists exist or are null.
      /*Postcondition: the parameter is the 'value' of a new node at the head
      of the list and the next reference points to the previous head reference */

      Node newNode = new Node(); //initialise new node
      newNode.setValue(newValue);//assign new value to new node
      if(head==null){
          head = new Node();
          head.setNext(newNode);
      }else{
          Node temp = head.getNext(); //temp stores head's current "next"
          newNode.setNext(temp); //set new node's next to temp
          head.setNext(newNode); //link head to the new node now
      }
  }

  public String toString(){
      //Precondition: list1 exists or is null
      //Postcondition: Returns the characters of the list as a string.
      String list=""; //initialise string
      if(head==null){
          System.out.println("List is empty");
      }else{

              Node temp=head.getNext(); //head is null at beginning of list
              while(temp!=null){
                  list+=temp.getValue();
                  temp=temp.getNext(); //sets head pointer to next node in linked list
              }
              //list+=head.getNext().getValue();
              //list+=head.getNext().getNext().getValue();
              //list+=head.getNext().getNext().getNext().getValue();
              //list+=head.getNext().getNext().getNext().getNext().getValue();
      }
      return list;
  }
}