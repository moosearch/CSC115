class TreeNode<T>{
    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    TreeNode(T newData){
        this.data = newData;
        this.leftChild = null;
        this.rightChild = null;
    }

    public TreeNode<T> getLeftChild(){
        return leftChild;
    }

    public TreeNode<T> getRightChild(){
        return rightChild;
    }

    public T getData(){
        return data;
    }

    public void setData(T newData){
        data = newData;
    }

    public void setLeftChild(TreeNode<T> left){
        this.leftChild = left;
    }

    public void setRightChild(TreeNode<T> right){
        this.rightChild = right;
    }

    public String toString(){
        return data.toString();
    }

    public static void main(String[] args){
        // ***TEST*** your generic TreeNode before moving on to the next part of the lab.
        TreeNode<Integer> test = new TreeNode<Integer>(10);
    }
}
