package datastructures.linkedlist;

import lombok.val;

/**
 * @author Bharath.MC
 * @since Dec-2020
 */
public class Node {
    int value;
    Node next;

    public Node(int value){
        this.value = value;
        next = null;
    }
}