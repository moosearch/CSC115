public class Node{
	// Add any instance variables that are needed here.
	Person data;
	Node next;

	public Node(Person newPerson){
		// FILL IN THIS METHOD
		data = newPerson;
		next = null;
	}

	public Person getData(){
		// FILL IN THIS METHOD
		return data;
	}

	public Node getNext(){
		// FILL IN THIS METHOD
		return next;
	}

	public void setData(Person newData){
		// FILL IN THIS METHOD
		data = newData;
	}

	public void setNext(Node newNext){
		// FILL IN THIS METHOD
		next = newNext;
	}

	public String toString(){
		// FILL IN THIS METHOD
		return data.toString();
	}

	public static void main(String [] args){

	}
}