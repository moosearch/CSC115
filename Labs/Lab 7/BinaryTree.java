public class BinaryTree<T>{
    // Keeps track of the root node of the BinaryTree.
    private TreeNode<T> root;

    // Keeps track of the number of TreeNodes in the BinaryTree.
    private int size;

    public TreeNode<T> getRoot(){
        return root;
    }

    public int getSize(){
        return size;
    }

    // Fill in this constructor so that it creates an empty BinaryTree.
    public BinaryTree(){
        //TreeNode<T> tree = new TreeNode<T>(null);
        root = null;
        size = 0;
    }

    // Fill in this constructor so that it creates a BinaryTree with one
    // TreeNode<T> storing the specified item.
    public BinaryTree(T item){
        root = new TreeNode<T>(item);
        size = 1;
    }

    // Fill in this constructor so that it creates a new TreeNode<T> to store the item, and then
    // sets its children to be the root nodes of the two subtrees being passed into this method.
    // Note that you will need to deal with the case where one or both of the subtrees is null.
    public BinaryTree(T item, BinaryTree<T> leftSubTree, BinaryTree<T> rightSubTree){
        root = new TreeNode<T>(item);
        size = 1;

        //if left sub tree not empty, set node to that tree, update size
        if(leftSubTree != null){
            root.setLeftChild(leftSubTree.getRoot());
            size = size + leftSubTree.getSize();
        }
        //same with right side
        if(rightSubTree != null){
            root.setRightChild(rightSubTree.getRoot());
            size = size + rightSubTree.getSize();
        }
    }


    public boolean isEmpty(){
        if(root==null){
            return true;
        }else{
            return false;
        }
    }

    public int height(){
        return recursiveHeight(root);
    }

    // Remember that the height of an empty tree should be zero.
    private int recursiveHeight(TreeNode<T> current){
        int height = 0;
        if(current!=null){
            int leftHeight = recursiveHeight(current.getLeftChild());
            int rightHeight = recursiveHeight(current.getRightChild());
            height = Math.max(leftHeight,rightHeight)+1; //the +1 is the root itself
        }
        return height;
    }

    public String traversalInOrder(){
        return recursiveInOrder(root);
    }

    private String recursiveInOrder(TreeNode<T> current){
        String result = "";
        if(current!=null){
            result+=recursiveInOrder(current.getLeftChild());
            result+=current.toString()+ " ";
            result+=recursiveInOrder(current.getRightChild());
        }
        return result;
    }


    /*preorder transversal is where the node gets printed first, then the
    node's left child gets printed after, then the node's right child. this is
    done recursively to ensure that the left child of all nodes gets printed first*/
    public String traversalPreOrder(){
        return recursivePreOrder(root);
    }

    private String recursivePreOrder(TreeNode<T> current){
        String result = "";
        if(current!=null){
            result+=current.getData()+" ";
            String leftSide = recursivePreOrder(current.getLeftChild());
            String rightSide = recursivePreOrder(current.getRightChild());
            result+=leftSide+rightSide;
        }
        return result;
    }
    /*postorder transversal is where the parent node gets printed last (ie. children
    of said node get printed before the parent does). so */
    public String traversalPostOrder(){
        return recursivePostOrder(root);
    }

    private String recursivePostOrder(TreeNode<T> current){
        String result = "";
        if(current!=null){
            String leftSide = recursivePostOrder(current.getLeftChild());
            String rightSide = recursivePostOrder(current.getRightChild());
            result+=leftSide+rightSide;
            result+=" "+current.getData();
        }
        return result;
    }

    public static void main(String[] args){
        // Creates five BinaryTrees and links them together.
        BinaryTree<Integer> test0 = new BinaryTree<Integer>(0);
        BinaryTree<Integer> test1 = new BinaryTree<Integer>(1);
        BinaryTree<Integer> test2 = new BinaryTree<Integer>(2, null, test1);
        BinaryTree<Integer> test3 = new BinaryTree<Integer>(3, test0, null);
        BinaryTree<Integer> test4 = new BinaryTree<Integer>(4, test2, test3);

        // Test the size.
        System.out.println("Size of the binary tree: " + test4.getSize());

        // The following code will allow you to visualize the BinaryTree as you implement
        // its basic functionality.
        DrawableBTree<Integer> tree = new DrawableBTree<Integer>(test4);
        tree.showFrame();


        //Test height
        System.out.println("The height of the binary tree: " + test4.height());


        // Test the InOrder traversal.
        System.out.println("InOrder traversal of tree: " + test4.traversalInOrder());
        System.out.println("PreOrder traversal of tree: "+ test4.traversalPreOrder());
        System.out.println("PostOrder traversal of tree:"+ test4.traversalPostOrder());
    }
}