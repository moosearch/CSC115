//Student Name: Wesley Chow
//Student Number: V00727646
//CSC 115 Java section
//Due Oct 26, 2012 @ 3PM
//Assignment 3
/*String Class using linked lists; has concatenate, repeat, copy,
subtring, and character count functions*/

public class StringADT implements ADT{

  private Node head;
  private int counter;

  public void concat(StringADT list1, StringADT list2){
      //Precondition: the lists exist or are null.
      /*Postcondition: the implicit parameter this points to the
      concatenation of list1 and list2; the nodes of the concatenated are separate
      from the nodes of list1 and list2.*/

      //initialise an empty list big enough to hold concatenation of the strings
      int concatLength = list1.leng() + list2.leng();
      for(int i = 0; i < concatLength; i++) {
          Node temp = new Node();
          temp.setNext(head);
          head = temp;
      }

      Node curNode = head;
      Node listNode = list1.head;
      for(int j = 0; j < list1.leng(); j++) {
          curNode.setValue(listNode.getValue());
          curNode = curNode.getNext();
          listNode = listNode.getNext();
      }

      listNode = list2.head;
      for(int l = 0; l < list2.leng(); l++) {
          curNode.setValue(listNode.getValue());
          curNode = curNode.getNext();
          listNode = listNode.getNext();
      }
      counter = concatLength;
  }

  public void copy(StringADT list1){
      //Precondition:  the list exists or is null .
      //Postcondition:  this points to a a copy of list1.
      //The nodes of the copied list are separate from the nodes of list1.

      head = null;
      //create empty linked list
      for(int i = 0; i < list1.leng(); i++) {
          Node temp = new Node();
          temp.setNext(head);
          head = temp;
      }

      Node curNode = head; //current node = head of new list
      Node listNode = list1.head; //reference same as list1.head
      for (int j = 0; j < list1.leng(); j++){
          curNode.setValue(listNode.getValue());
          curNode = curNode.getNext();
          listNode = listNode.getNext();
          System.out.println("Number:"+j);
      }
      counter = list1.leng();
  }

  public void repeats(StringADT list1 ,int n){
      //Precondition: n >= 0.
      /*Postcondition: this points to the concatenation of n copies of
      list1.  If n = 0, then the copied list is the empty string represented by a
      linked list consisting of only the null pointer.*/

      StringADT repeater = new StringADT();
      if (n > 0) {
          counter = 0;
          for(int i = 0; i < n; i++) {
              concat(repeater, list1); //combine the string n times
          }
          counter = (list1.leng() * n);
      } else if(n <= 0) {
        //implies n points to null or n is negative value
      }
  }

  public void assign(String list1){
      //Precondition: None.  (Notice that list1 is a Java string.)
      head=null;
      for(int i = list1.length()-1; i >= 0; i--) {
          Node next = new Node();
          next.setValue(list1.charAt(i));
          next.setNext(head);
          head = next;
          counter++;
      }
      //Postcondition: this points to the link list
      //representing the string as list1.
  }

  public void substring(StringADT list1, int x, int y){
      //Precondition: 0<= x <= y < leng(list1).
      /*Postcondition: this points to the link list representing the
      substring of list1 that goes from the xth indexed character to the yth indexed
      character.*/

      //initialise empty link list for the substringed list
      head = null;
      if(x >= 0 && x <= y && y < list1.leng()) {
          //loop until you have a list of size y-x
          for(int i = x; i < y; i++) {
              Node temp = new Node();
              temp.setNext(head);
              head = temp;
          }
          //assign
          Node start = head;
          Node listNode = list1.head;
          //keep looping until it gets to specified start spot
            for(int j = 0; j < y; j++){
                if (j >= x){
                    start.setValue(listNode.getValue());
                    start = start.getNext(); //move new list pointer
                }
                listNode = listNode.getNext();//go to next item
            }
      }
  }
  public int leng()
  {
      return counter;
      //Precondition: None.
      //Postcondition: Returns the number of characters of list1.
  }

  public String toString(){
      //Precondition: list1 exists or is null
      if(head==null){
          System.out.println("List is empty");
          return null;
      }else{
          String result = "";
          Node temp = head;
          //loop until temp points to null
          while(temp!=null){
              result+=temp.getValue();
              temp = temp.getNext();
          }
          return result;
      }
      //Postcondition: Displays the characters of list1 on the terminal.
  }

}