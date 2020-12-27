package excersise.collection;

import java.util.*;

/**
 * @author Bharath.MC
 * @since Nov-2020
 */
public class CollectionExercise01 {

    public static void TreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(9);
        treeSet.add(1);
        treeSet.add(0);
        treeSet.add(-1);
        treeSet.add(-15);
        treeSet.add(100);

        System.out.println(treeSet);
        System.out.println(treeSet.ceiling(3));
        System.out.println(treeSet.floor(11));
        System.out.println(treeSet.headSet(5));
        System.out.println(treeSet.tailSet(2));
        System.out.println(treeSet.subSet(1, 9));
    }

    /**
     * - It uses a dynamic array to store the duplicate element of different data types
     * - maintains the insertion order
     * - non-synchronized
     * - can be randomly accessed by index
     */
    public static void ArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(30);
        list.add(-10);
        list.add(-50);
        System.out.println(list.get(3));
        System.out.println(list);
    }

    /**
     * - It uses a doubly linked list internally to store the elements
     * - duplicate allowed
     * - insertion order preserved
     * - not synchronized
     * - manipulation is fast because no shifting is required unlike arraylist
     */
    public static void LinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(30);
        list.add(-10);
        list.add(-50);
        System.out.println(list);

        list.push(100);
        list.push(120);
        System.out.println(list.pop());
        System.out.println(list);
    }

    public static void main(String[] args) {
        LinkedList();
    }

}
