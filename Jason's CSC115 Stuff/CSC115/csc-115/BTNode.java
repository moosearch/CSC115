public class BTNode {
	private Object item;
	private BTNode left;
	private BTNode right;

	public BTNode(Object o) {
		this.item = o;
		this.left = null;
		this.right = null;
	}

	public BTNode(Object o, BTNode left, BTNode right){
		this.item = o;
		this.left = left;
		this.right = right;

	}

	public Object getItem() {
		return this.item;
	}

	public BTNode getLeft() {
		return this.left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return this.right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	public int compareTo(BTNode n) {
		// Should throw: incompatible type exception
		if (n.item instanceof Number)
			return (Integer)this.item - (Integer)n.item;
		//else
		String itemString = item.toString();
		return itemString.compareTo(n.item.toString());
	}
}