package singleLinkedList;

import java.util.Stack;

public class Util {

    public static LinkedList reverse(LinkedList linkedList) {
        LinkedList result = new LinkedList();
        Node current = linkedList.getNth(0);
        Stack<Node> stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.getNext();
        }

        while (!stack.empty()) {
            result.insertLast(stack.pop().getData());
        }
        return result;
    }

    public static void reverse_enhanced(LinkedList linkedList) {
        Node current = linkedList.getHead();
        Node next = null;
        Node previous = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            if (previous == null)
                linkedList.setTail(current);
            previous = current;
            current = next;
        }

        linkedList.setHead(previous);
    }

}
