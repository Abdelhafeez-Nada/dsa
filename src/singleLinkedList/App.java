package singleLinkedList;

public class App {

    public static void main(String[] args) throws InterruptedException {
        LinkedList linkedList = new LinkedList();
        linkedList.insertLast(1);
        linkedList.print();
        System.out.println("---------------------");

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertLast(2);
        linkedList2.print();
        System.out.println("---------------------");

        linkedList.insertAlternate(linkedList2);

        linkedList.print();
        System.out.println("---------------------");
        System.out.println(linkedList.getTail());

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
