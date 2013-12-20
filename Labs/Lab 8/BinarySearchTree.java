public class BinarySearchTree<T extends Comparable<? super T>>{
    // Keeps track of the root node of the BinarySearchTree.
    private TreeNode<T> root;

    // Keeps track of the number of TreeNodes in the BinarySearchTree.
    private int size;

    // Creates an empty binary search tree.
    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public TreeNode<T> getRoot(){
        return root;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return (root == null);
    }

    public String traversalInOrder(){
        return recursiveInOrder(root);
    }

    private String recursiveInOrder(TreeNode<T> current){
        String result = "";
        if (current != null){
            result += recursiveInOrder(current.getLeftChild());
            result += current.toString() + " ";
            result += recursiveInOrder(current.getRightChild());
        }
        return result;
    }

    // The entry way to the search.  The user calls search and passes in an item, and the
    // search will either return that item (if it is in the tree) or a null
    // (if target is not in the tree).
    public T search(T target){
        return search(this.getRoot(), target);
    }

    // Recursive search method for finding a target in a BinarySearchTree.  Compares the current node
    // with the target, goes down left subtree if current node is 'bigger' than target, down right
    // subtree if current node is 'smaller'.
    private T search(TreeNode<T> current, T target){
        // If current is null, we have reached the bottom of this path.
        // The target is therefore not in the tree and null is returned.
        if (current == null){
            return null;
        }else{
            // We have found the target, return it.
            if (target.compareTo(current.getData()) == 0){
                return current.getData();
            }
            // Target is 'smaller' than the current node, recurse to the left.
            else if (target.compareTo(current.getData()) < 0){
                return search(current.getLeftChild(), target);
            }
            // Target is 'bigger' than the current node, recurse to the right.
            else{
                return search(current.getRightChild(), target);
            }
        }
    }
    /*BIG O ANALYSIS OF SEARCH ALGORITHM
    Best case: O(1) since the item could be at the root of the tree.
    Average case: O(log[n])
    Worst case: O(n)
    */


    // Entry way to insert.  The user passes in a piece of data to be inserted into the
    // binary search tree.
    public void insert(T newItem){
        // FILL IN THIS METHOD
        // Special case: if tree is empty, all we need to do is put the item in a node and make
        // it the root of the BST.
        // Otherwise, call recursiveInsert to insert newItem at the correct position in the BST.
        if(isEmpty()){
            TreeNode<T> n = new TreeNode<T>(newItem);
            root = n;
            size++;
        }else{
            recursiveInsert(root,newItem);
        }
    }

    // Recursive algorithm that finds the correct place to insert newItem in the binary search tree.  Operates like search,
    // except we look down the subtrees before going down them, since we need to store the node
    // *before* we hit a null connection in order to add to the BST.
    private void recursiveInsert(TreeNode<T> current, T newItem){
        // FILL IN THIS METHOD
        // Assume there will be no duplicate values.
        // If newItem is less than value at current node, look down left subtree.
        // If left child is not null, recurse left.  If left child is
        // null, insert new item as the left child.
        if(newItem.compareTo(current.getData()) < 0){

            if(current.getLeftChild()==null){
                TreeNode<T> leftRoot = new TreeNode<T>(newItem);
                current.setLeftChild(leftRoot);
                size++;
            }else{
                recursiveInsert(current.getLeftChild(),newItem);
            }

        }

        if( newItem.compareTo(current.getData()) > 0){

            if(current.getRightChild()==null){
                TreeNode<T> rightRoot = new TreeNode<T>(newItem);
                current.setRightChild(rightRoot);
                size++;
            }else{
                recursiveInsert(current.getRightChild(),newItem);
            }

        }

        // If newItem is greater than value at current node, look down right subtree.
        // If right child is not null, recurse right.  If right child is
        // null, insert new item as the right child.
    }

    public String traversalLevelOrder(){
        // FILL IN THIS METHOD
        //Create an empty queue and enqueue the root of the tree.
        // while the queue isn't empty
        //      dequeue the front item
        //      add its data to the String
        //      enqueue its children if they are not null
        String ret = "";
        Queue<TreeNode<T>> q = new Queue<TreeNode<T>>();
        q.enqueue(root);
        while(q.isEmpty()==false){
            TreeNode<T> n = q.dequeue();
            ret += n.getData() + " ";

            if(n.getLeftChild() != null){
               q.enqueue(n.getLeftChild());
            }

            if(n.getRightChild() != null){
               q.enqueue(n.getRightChild());
            }
        }
        return ret;
    }

    public static void main(String[] args){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.insert(30);
        bst.insert(40);
        bst.insert(25);
        bst.insert(15);
        bst.insert(27);
        bst.insert(55);
        bst.insert(42);


        System.out.println("Size of tree: " + bst.getSize());
        System.out.println("InOrder traversal should be in ascending order: " + bst.traversalInOrder());

        // Visualizes the tree - useful for debugging purposes.
        DrawableBSTree<Integer> figure = new DrawableBSTree<Integer>(bst);
        figure.showFrame();
        System.out.println("LevelOrder traversal: " + bst.traversalLevelOrder());
    }
}