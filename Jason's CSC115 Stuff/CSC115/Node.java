public class Node{
	Object value;
	Node next;

	public Node(){
		next=null;
	}

	public Object getValue(){
		return value;
	}

	public void setValue(Object val){
		value = val;
	}

	public Node getNext(){
			return next;
		}

	public void setNext(Node nod){
			next = nod;
	}

	public boolean equals(Object v) {
	      if(v instanceof Node){
			Node vn = (Node)v;
	      	if (vn == null)return false;
	      	return value.equals(vn.getValue());}
	      else
	      	return false;
	   }

	public String toString() {
	      return this.toString();
	   }


}