package datastructures.linkedlist;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class LinkedList {
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAtPostion(int value, int position) {

        if (position <= 0 || position > size()) {
            System.out.println("Error, invalid position");
            return;
        }

        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        if (position >= size()) {
            tail.next = newNode;
            tail = newNode;
            size++;
            return;
        }

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }

        Node current = head;
        Node previous = current;
        int counter = 0;
        while (current != null && position != counter) {
            previous = current;
            current = current.next;
            counter++;
        }
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
    }

    public void insertSorted(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }

        Node current = head;
        Node previous = current;
        while (current != null && current.value < value) {
            previous = current;
            current = current.next;
        }
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
    }


    public void PrintList(LinkedList list) {
        if (list.head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = list.head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void PrintListRecursive(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        PrintListRecursive(head.next);
    }

    public void PrintListRecursiveReverse(Node head) {
        if (head == null) {
            return;
        }
        PrintListRecursive(head.next);
        System.out.println(head.value);
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Linked List is Empty");
            return;
        }
        System.out.println("Deleting " + head.value);
        head = head.next;
        size--;
        if (isEmpty())
            tail = null;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        if (head == tail) {
            System.out.println("Deleting last node " + head.value);
            head = tail = null;
            size--;
            return;
        }

        Node previous = head;
        int counter = 1;
        while (counter < size - 1) {
            previous = previous.next;
            counter++;
        }
        tail = previous;
        previous = previous.next;
        System.out.println("Deleting last " + previous.value);
        tail.next = null;
        size--;
    }

    public void DeleteLast(LinkedList list) {
        if (list.head == null) {
            System.out.println("List is empty");
            return;
        }
        if (list.head.next == null) {
            System.out.println("Deleting Last Node.." + list.head.value);
            list.head = null;
            size--;
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
        size--;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is Empty..");
            return;
        }

        if (position <= 0 || position > size()) {
            System.out.println("Invalid position to delete");
            return;
        }

        if (position <= 1) {
            System.out.println("deleting element " + head.value);
            head = head.next;
            size--;
            return;
        }

        Node present = head;
        int counter = 1;
        while (counter < position - 1) {
            present = present.next;
            counter++;
        }
        System.out.println("Deleting " + present.next.value);
        present.next = present.next.next;
        size--;
    }

    public void DeleteNodeAtPosition(LinkedList list, int position) {
        if (list.head == null) {
            System.out.println("List is Empty..");
            return;
        }
        if (position <= 1) {
            //DeleteFirst(list);
            return;
        }
        if (!(position <= size)) {
            System.out.println(String.format("Position[%s] unavailable as current Linkedlist size[%s]", position, size));
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


    public void DeleteByKey(LinkedList list, int key) {
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

    public int LengthOfLinkedList(LinkedList list) {
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

    private int LengthRecursion(Node head) {
        if (head == null)
            return 0;
        return 1 + LengthRecursion(head.next);
    }

    public int GetLengthRec(LinkedList list) {
        return LengthRecursion(list.head);
    }

    public boolean searchElement(Node head, int key) {
        if (head == null)
            return false;
        if (head.value == key)
            return true;
        else
            return searchElement(head.next, key);
    }

    public int GetNthNodeFromBeginning(Node head, int index) {
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

    /**
     * Find Nth node form end
     * n=3, return 3rd node from last
     * Cannot use list counter/size variable
     * 2 pointers, pointer 1 is at 1st position and pointer 2 is at 3rd node.
     * when 3rd node reaches null, we return 1st pointer
     */
    public int nthNodeFromEnd(int nthNode) {
        if (head == null) {
            System.out.println("Empty list");
            return -1;
        }
        Node basePointer = head;
        Node tempPointer = head;

        int counter = 0;
        while (tempPointer != null && counter < nthNode) {
            tempPointer = tempPointer.next;
            counter++;
        }

        if (counter != nthNode)
            return -1;

        while (tempPointer != null) {
            basePointer = basePointer.next;
            tempPointer = tempPointer.next;
        }

        return basePointer.value;

    }

}
