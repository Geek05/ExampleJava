package datastructures.linkedlist;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class DemoLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.InsertDataAtEnd(linkedList, 10);
        LinkedList.InsertDataAtEnd(linkedList, 20);
        LinkedList.InsertDataAtEnd(linkedList, 40);
        LinkedList.InsertDataAtEnd(linkedList, 60);
        System.out.println("--");
        LinkedList.PrintList(linkedList);
        System.out.println("--");
        System.out.println(LinkedList.GetNthNode(linkedList.head, 1));

    }
}
