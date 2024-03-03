package singleLinkedList;

public class App {

    public static void main(String[] args) throws InterruptedException {
        LinkedList linkedList = new LinkedList();
        linkedList.inserSorted(5);
        System.out.println();
        linkedList.print();
        System.out.println("HEAD: " + linkedList.getHead());
        linkedList.inserSorted(3);
        System.out.println();
        linkedList.print();
        System.out.println("HEAD: " + linkedList.getHead());
        linkedList.inserSorted(1);
        System.out.println();
        linkedList.print();
        System.out.println("HEAD: " + linkedList.getHead());
        linkedList.inserSorted(2);
        System.out.println();
        linkedList.print();
        System.out.println("HEAD: " + linkedList.getHead());
        linkedList.inserSorted(4);

        System.out.println();
        linkedList.print();
        System.out.println();

        // linkedList.swapPairs();
        // linkedList.print();
        // System.out.println();

        // linkedList.removeByValue(5);
        // linkedList.print();
        // System.out.println();

        // linkedList.removeByValue(1);
        // linkedList.print();
        // System.out.println();
        // linkedList.reverse_rec();
        // linkedList.print();
        // System.out.println();
        // System.out.println("HEAD: " + linkedList.getHead().getData() + "TAIL: " +
        // linkedList.getTail().getData());

        // System.out.println();
        // linkedList.print();
        // System.out.println("-------------------------------------------");

        // linkedList.reverse();
        // linkedList.print();
        // System.out.println();
        // System.out.println("HEAD: " + linkedList.getHead().getData() + "TAIL: " +
        // linkedList.getTail().getData());

        // System.out.println(linkedList.getHead());

        // System.out.println("-------------------------------------------");

        // Thread.sleep(5000);
        // linkedList.print();
        // System.out.println();
        // System.out.println("HEAD: " + linkedList.getHead().getData() + "TAIL: " +
        // linkedList.getTail().getData());

        // System.out.println(linkedList.getNth(0));

        // System.out.println();

        // Node head = linkedList.getHead();
        // Node tail = linkedList.getTail();
        // System.out.println("HEAD: " + head.getData() + " , TAIL: " + tail.getData());

        // linkedList.print();

        // LinkedList reversed = Util.reverse(linkedList);

        // System.out.println();
        // reversed.print();
        // linkedList.removeNth(0);
        // System.out.println();
        // linkedList.print();
        // linkedList.removeNth(0);
        // System.out.println();
        // linkedList.print();
        // linkedList.removeNth(2);
        // System.out.println();
        // linkedList.print();
        // LinkedList linkedList2 = new LinkedList();
        // linkedList2.insertLast(1);
        // linkedList2.insertLast(2);
        // linkedList2.insertLast(3);
        // linkedList2.insertLast(4);
        // linkedList2.insertLast(5);

        // System.out.println(linkedList.equals(linkedList2));
        // linkedList.print();

        // linkedList.insertFirst(999);
        // linkedList.print();
        // System.out.println();
        // linkedList.insertLast(999);
        // linkedList.print();
        // System.out.println();
        // linkedList.removeFirst();
        // linkedList.print();
        // System.out.println();
        // linkedList.removeLast();
        // linkedList.print();System.out.println("-------------------------------------------");

        // linkedList.reverse();
        // linkedList.print();
        // System.out.println();
        // System.out.println("HEAD: " + linkedList.getHead().getData() + "TAIL: " +
        // linkedList.getTail().getData());

        // System.out.println(linkedList.findTransposition_enhanced(1));
        // System.out.println();
        // linkedList.print();
        // System.out.println(linkedList.findTransposition(2));
        // linkedList.print();

        // System.out.println(linkedList.searchByValue(1));
        // System.out.println(linkedList.searchByValue(2));
        // System.out.println(linkedList.searchByValue(3));
        // System.out.println(linkedList.searchByValue(4));
        // System.out.println(linkedList.searchByValue(5));

    }

    private static Node head;

    // public static void main(String[] args) {
    // Node n5 = new Node(5);
    // Node n4 = new Node(4, n5);
    // Node n3 = new Node(3, n4);
    // Node n2 = new Node(2, n3);
    // Node n1 = new Node(1, n2);
    // head = n1;
    // print(n1);

    // System.out.println(find(3));
    // }

    // find(value) >> searches for a node with a given value
    private static Node find(int value) {
        Node current = head;
        return backtrack(current, value);
        // while (current != null) {
        // if (current.getData() == value)
        // return current;
        // current = current.getNext();
        // }
        // return null;
    }

    // current != null
    // current = current.getNext();
    private static Node backtrack(Node current, int value) {
        if (current == null)
            return null;
        if (current.getData() == value)
            return current;
        return backtrack(current.getNext(), value);
    }

    private static void print(Node itr) {
        if (itr == null)
            return;
        System.out.println(itr.getData());
        print(itr.getNext());
    }
}
