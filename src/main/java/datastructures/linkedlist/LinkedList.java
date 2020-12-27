package datastructures.linkedlist;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class LinkedList {
    Node head;
    Node tail;
    static int nodeCount;

    public static void InsertDataAtEnd(LinkedList list, int value) {
        Node newNode = new Node(value);

        if (list.head == null) {
            list.head = newNode;
            list.tail = newNode;
            nodeCount++;
            return;
        }
        list.tail.next = newNode;
        list.tail = newNode;
        nodeCount++;
    }

    public static void InsertDataAtBeginning(LinkedList list, int value) {
        Node newNode = new Node(value);

        if (list.head == null) {
            list.head = newNode;
            list.tail = newNode;
            nodeCount++;
            return;
        }

        newNode.next = list.head;
        list.head = newNode;
        nodeCount++;
    }

    public static void InsertDataAtPostion(LinkedList list, int value, int position) {
        if (position > nodeCount) {
            System.out.println("insertion at Position is not possible [position > nodeCount] as nodeCount = " + nodeCount);
            return;
        }

        if (list.head == null && position != 1) {
            System.out.println("insertion at Position[list.head == null && position!= 1] is not possible as nodeCount = " + nodeCount);
            return;
        }

        Node newNode = new Node(value);
        if (position == 1) {
            newNode.next = list.head;
            list.head = newNode;
            nodeCount++;
            return;
        }

        Node currentNode = list.head;
        Node previousNode = currentNode;
        int counter = 1;
        while (currentNode != null && counter < position) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            counter++;
        }
        if (counter <= position) {
            previousNode.next = newNode;
            newNode.next = currentNode;
            nodeCount++;
        } else {
            System.out.println("insertion at Position is not possible as nodeCount = " + nodeCount);
        }
    }

    public static void PrintList(LinkedList list) {
        if (list.head == null) {
            System.out.println("List is Empty!");
            return;
        }
        Node temp = list.head;
        System.out.println(" -- Printing List -- ");
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public static void PrintListRecursive(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        PrintListRecursive(head.next);
    }

    public static void PrintListRecursiveReverse(Node head) {
        if (head == null) {
            return;
        }
        PrintListRecursive(head.next);
        System.out.println(head.value);
    }

    public static void DeleteFirst(LinkedList list) {
        if (list.head == null) {
            System.out.println("List is empty");
            return;
        }
        if (list.head.next == null) {
            System.out.println("Deleting Last Node.." + list.head.value);
            list.head = null;
            nodeCount--;
            return;
        }
        System.out.println("Deleting First Node.. " + list.head.value);
        list.head = list.head.next;
        nodeCount--;
    }

    public static void DeleteLast(LinkedList list) {
        if (list.head == null) {
            System.out.println("List is empty");
            return;
        }
        if (list.head.next == null) {
            System.out.println("Deleting Last Node.." + list.head.value);
            list.head = null;
            nodeCount--;
            return;
        }
        Node currentNode = list.head;
        Node previousNode = currentNode;
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        System.out.println("Deleting Last Node.." + currentNode.value);
        previousNode.next = null;
        nodeCount--;
    }

    public static void DeleteNodeAtPosition(LinkedList list, int position) {
        if (list.head == null) {
            System.out.println("List is Empty..");
            return;
        }
        if (position <= 1) {
            DeleteFirst(list);
            return;
        }
        if (!(position <= nodeCount)) {
            System.out.println(String.format("Position[%s] unavailable as current Linkedlist size[%s]", position, nodeCount));
            return;
        }
        int counter = 1;
        Node currentNode = list.head;
        Node previousNode = currentNode;
        while (currentNode.next != null && (counter <= position)) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            counter++;
        }
        System.out.println("Deleting " + previousNode.next.value);
        previousNode.next = currentNode.next;
    }

    public static void DeleteByKey(LinkedList list, int key) {
        if (list.head == null) {
            System.out.println("List is empty");
            return;
        }
        if (list.head.value == key) {
            System.out.println("Deleting key " + key);
            list.head = list.head.next;
        }

        Node currentNode = list.head;
        Node previousNode = currentNode;
        while (currentNode != null) {
            if (currentNode.value == key)
                break;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            System.out.println("Key Not Found");
        } else {
            System.out.println("Deleting key " + key);
            previousNode.next = currentNode.next;
        }
    }

    public static int LengthOfLinkedList(LinkedList list) {
        Node temp = list.head;
        int length = 0;
        if (temp != null) {
            while (temp != null) {
                temp = temp.next;
                length++;
            }
        }
        return length;
    }

    private static int LengthRecursion(Node head) {
        if (head == null)
            return 0;
        return 1 + LengthRecursion(head.next);
    }

    public static int GetLengthRec(LinkedList list) {
        return LengthRecursion(list.head);
    }

    public static boolean searchElement(Node head, int key) {
        if (head == null)
            return false;
        if (head.value == key)
            return true;
        else
            return searchElement(head.next, key);
    }

    public static int GetNthNode(Node head, int index) {
        if (head == null || index < 1) {
            return 0;
        }

        Node current = head;
        Node previous = current;
        int counter = 0;
        while (current != null && counter < index) {
            previous = current;
            current = current.next;
            counter++;
        }
        if (previous.next != null)
            return previous.value;
        else
            return 0;
    }
}
