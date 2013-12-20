//Student Name - Jason Curt
//Student Number - V00761884

public class StringADT implements ADT {

private Node head;
private int counter;

  public StringADT() {
    head = null;
    counter = 0;
  }

  public void concat(StringADT list1, StringADT list2) {
//Precondition: the lists exist or are null.
/*Postcondition: the implicit parameter this points to the
concatenation of list1 and list2; the nodes of the concatenated are separate
from the nodes of list1 and list2.*/
    int totalLength = list1.leng() + list2.leng();
    for(int i = 0; i < totalLength; i++) {
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
    counter = totalLength;
  }

  public void copy(StringADT list1) {
  //Precondition:  the list exists or is null .
  //Postcondition:  this points to a a copy of list1.
  //The nodes of the copied list are separate from the nodes of list1.
    head = null;

    for(int i = 0; i < list1.leng(); i++) {
      Node temp = new Node();
      temp.setNext(head);
      head = temp;
    }

    Node curNode = head;
    Node listNode = list1.head;
    for (int j = 0; j < list1.leng(); j++) {
      curNode.setValue(listNode.getValue());
      curNode = curNode.getNext();
      listNode = listNode.getNext();
    }
    counter = list1.leng();
  }

  public void repeats(StringADT list1, int n) {
//Precondition: n >= 0.
/*Postcondition: this points to the concatenation of n copies of
list1.  If n = 0, then the copied list is the empty string represented by a
linked list consisting of only the null pointer.*/
    StringADT repeater = new StringADT();
    if (n > 0) {
      counter = 0;
      for(int i = 0; i < n; i++) {
        concat(repeater, list1);
      }
      counter = (list1.leng() * n);
    } else if(n <= 0) {
      //does nothing since list points to null
    }
  }

  public void assign(String list1) {
//Precondition: None.  (Notice that list1 is a Java string.)
//Postcondition: this points to the link list
//representing the string as list1.
    head = null;
    for(int i = list1.length()-1; i >= 0; i--) {
      Node next = new Node();
      next.setValue(list1.charAt(i));
      next.setNext(head);
      head = next;
    }
    counter = list1.length();
  }

  public void substring(StringADT list1, int x, int y) {
//Precondition: 0<= x <= y < leng(list1).
/*Postcondition: this points to the link list representing the
substring of list1 that goes from the xth indexed character to the yth indexed
character.*/
    head = null;
    if(x >= 0 && x <= y && y < list1.leng()) {
      for(int i = x; i < y; i++) {
        Node temp = new Node();
        temp.setNext(head);
        head = temp;
      }
    }

    Node startNode = head;
    Node listNode = list1.head;
    if(x >= 0 && x <= y && y < list1.leng()) {
      for(int j = 0; j < y; j++) {
        if (j >= x) {
          startNode.setValue(listNode.getValue());
          startNode = startNode.getNext();
        }
        listNode = listNode.getNext();
      }
    }
  }

  public int leng() {
//Precondition: None.
//Postcondition: Returns the number of characters of list1.
    return counter;
  }

  public String toString() {
//Precondition: list1 exists or is null
//Postcondition: Displays the characters of list1 on the terminal.
    String result = "";
    Node temp = head;
    while(temp != null) {
      result += temp.getValue();
      temp = temp.getNext();
    }
    return result;
  }
}