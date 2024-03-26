package singleLinkedList;

public class App {

    public static void main(String[] args) throws InterruptedException {
        LinkedList linkedList = new LinkedList();
        linkedList.insertLast(1, 1, 5, 2, 2, 2, 3);

        linkedList.print();
        System.out.println("-----------------------------------");
        linkedList.removeAllDublicates();
        linkedList.print();

        // Node node = linkedList.getNth(1);
        // Node curr = node;
        // System.out.println(node);
        // System.out.println(curr);
        // linkedList.removeNode(node);
        // System.out.println(node);
        // System.out.println(curr);

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
