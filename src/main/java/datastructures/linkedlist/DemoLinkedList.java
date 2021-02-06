package datastructures.linkedlist;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class DemoLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertSorted(10);
        linkedList.insertSorted(60);
        linkedList.insertSorted(20);
        linkedList.insertSorted(40);
        linkedList.insertSorted(30);
        linkedList.insertSorted(30);
        linkedList.insertSorted(50);
        System.out.println("--");
        linkedList.PrintList(linkedList);
        System.out.println(linkedList.nthNodeFromEnd(1));
    }
}
