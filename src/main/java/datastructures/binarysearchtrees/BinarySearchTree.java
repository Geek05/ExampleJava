package datastructures.binarysearchtrees;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class BinarySearchTree {

    public class Node{
        int element;
        Node left;
        Node right;

        public Node(int element, Node left, Node right){
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }

    Node root;

    public BinarySearchTree(){
        root = null;
    }

    public Node insert(Node tempRoot, int element){
        if(tempRoot != null){
            if(element < tempRoot.element){
                tempRoot.left = insert(tempRoot.left, element);
            } else if(element > tempRoot.element){
                tempRoot.right = insert(tempRoot.right, element);
            }
        } else {
            Node newNode = new Node(element, null, null);
            tempRoot = newNode;
        }
        return tempRoot;
    }

    public void inorder(Node tempNode){
        if(tempNode!=null) {
            inorder(tempNode.left);
            System.out.print(tempNode.element + " , ");
            inorder(tempNode.right);
        }
    }

    public void preorder(Node tempNode){
        if(tempNode!=null) {
            System.out.print(tempNode.element + " , ");
            preorder(tempNode.left);
            preorder(tempNode.right);
        }
    }

    public void postorder(Node tempNode){
        if(tempNode!=null) {
            postorder(tempNode.left);
            postorder(tempNode.right);
            System.out.print(tempNode.element + " , ");
        }
    }

    public boolean search(Node tempRoot, int element){
        if(tempRoot!=null){
            if(element == tempRoot.element)
                return true;
            if(element > tempRoot.element){
                return search(tempRoot.right, element);
            } else if(element < tempRoot.element){
                return search(tempRoot.left, element);
            }
        }
        return false;
    }

    public void delete(int element){

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 80);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 60);

        bst.inorder(bst.root);
        System.out.println();
        bst.preorder(bst.root);
        System.out.println();
        bst.postorder(bst.root);
        System.out.println();
        System.out.println(bst.search(bst.root, 10));
    }

}
