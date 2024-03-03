package singleLinkedList;

import java.util.Stack;

public class LinkedList {

    private Node head;
    private Node tail;

    public LinkedList() {
    }

    // print ()
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getData() + ", ");
            current = current.getNext();
        }
    }

    // insertEnd(int value)
    public void insertLast(int value) {
        // first node
        if (head == null) {
            head = new Node(value);
            tail = head;
            return;
        }
        tail.setNext(new Node(value));
        tail = tail.getNext();
    }

    public void insertFirst(int value) {
        // first node
        if (head == null) {
            head = new Node(value);
            tail = head;
            return;
        }
        Node node = new Node(value);
        node.setNext(head);
        head = node;
    }

    public void inserSorted(int value) {
        Node newNode = new Node(value);
        Node previous = null;
        if (head == null) {
            head = newNode;
            tail = head;
            return;
        }
        Node current = head;
        while (current != null && current.getData() < value) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            newNode.setNext(head);
            head = newNode;
            return;
        }
        if (current == null || previous == tail) {
            tail.setNext(newNode);
            tail = newNode;
            return;
        }
        previous.setNext(newNode);
        newNode.setNext(current);
    }

    public void removeFirst() {
        // if list empty
        if (head == null)
            return;
        // if list has single node
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        // else
        head = head.getNext();
    }

    public void removeNth(int n) {
        if (n == 0) {
            removeFirst();
            return;
        }
        int idx = 0;
        Node current = head;
        while (current.getNext() != null && idx < n) {
            if (idx + 1 == n) {
                if (current.getNext() == tail)
                    removeLast();
                else
                    current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
            idx++;
        }

    }

    public void removeLast() {
        // if list empty
        if (head == null)
            return;
        // if list has single node
        if (head == tail) {
            head = null;
            tail = null;
            return;
        }
        // else
        Node current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        current.setNext(null);
        tail = current;
    }

    public void removeByValue(int value) {
        if (this.head.getData() == value)
            removeFirst();
        if (this.getTail().getData() == value)
            removeLast();
        Node current = this.head.getNext();
        Node previous = this.head;
        while (current.getNext() != null) {
            if (current.getData() == value) {
                previous.setNext(current.getNext());
                current.setNext(null);
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public Node getNth(int n) {
        if (n == 0)
            return head;
        Node current = head;
        while (current != null && n >= 0) {
            if (n == 0)
                return current.getNext();
            current = current.getNext();
            n--;
        }
        return null;
    }

    public Node getNth_back(int n) {
        Node current = head;
        Stack<Node> stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.getNext();
        }
        int i = 0;
        while (!stack.empty()) {
            if (i == n)
                return stack.pop();
            stack.pop();
            i++;
        }

        return null;
    }

    public Node getNth_back_enhanced(int n) {
        Node rightPtr = head;
        Node leftPtr = head;
        int rightIndex = 0;
        int leftIndex = 0;
        while (rightPtr != tail) {
            rightPtr = rightPtr.getNext();
            rightIndex++;
        }

        while (rightIndex - leftIndex >= 0) {
            if (rightIndex - leftIndex == n) {
                return leftPtr;
            }
            leftIndex++;
            leftPtr = leftPtr.getNext();
        }

        return null;
    }

    public int searchByValue(int value) {
        int index = 0;
        Node current = head;
        for (; current != null; current = current.getNext()) {
            if (current.getData() == value)
                return index;
            index++;
        }
        return -1;
    }

    public void swapPairs() throws InterruptedException {
        Node first = head;
        if (first == null || first.getNext() == null)
            return;
        head = first.getNext();
        Node before = null;
        while (first != null && first.getNext() != null) {
            Node second = first.getNext();
            first.setNext(second.getNext());
            second.setNext(first);
            if (before != null)
                before.setNext(second);
            before = first;
            first = first.getNext();
        }
    }

    public int findTransposition_enhanced(int value) {
        int index = 0;
        Node previous = null;
        for (Node current = head; current != null; previous = current, index++, current = current.getNext()) {
            if (current.getData() == value) {
                if (previous == null) {
                    return index;
                }
                current.setData(previous.getData());
                previous.setData(value);
                return index - 1;
            }
        }
        return -1;
    }

    // (1)=>(2)=>(3)
    // value: 1 , value: 2, value: 3
    public int findTransposition(int value) {

        if (head.getData() == value)
            return 0;
        if (head.getNext().getData() == value) {
            Node temp = head.getNext();
            head.setNext(temp.getNext());
            temp.setNext(head);
            head = temp;
            return 0;
        }
        Node current = head;
        int n = 1;
        while (current.getNext().getNext() != null) {
            Node toShiftLeft = current.getNext().getNext();
            if (toShiftLeft.getData() == value) {
                Node complement = toShiftLeft.getNext();
                Node toShifRight = current.getNext();
                current.setNext(toShiftLeft);
                toShiftLeft.setNext(toShifRight);
                toShifRight.setNext(complement);
                return n;
            }
            current = current.getNext();
            n++;
        }
        return -1;
    }

    public void reverse() {
        Node current = this.head;
        Node next = null;
        Node previous = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            if (previous == null)
                this.tail = current;
            previous = current;
            current = next;
        }
        this.head = previous;
    }

    public void reverse_rec() {
        Node n = bactrack(this.head);
        System.out.println("----------- " + n);
        Node temp = head;
        this.head = this.tail;
        this.tail = temp;
        System.out.println(head);
    }

    /**
     * Node* f(Node* cur) {
     * if (cur && cur->next) {
     * Node* rem = f(cur->next);
     * rem->next = cur;
     * cur->next = nullptr;
     * }
     * return cur;
     * }
     */
    private Node bactrack(Node current) {
        System.out.println("CURRENT: " + current.getData());
        if (current.getNext() != null) {
            Node next = bactrack(current.getNext());
            next.setNext(current);
            current.setNext(null);
        }
        System.out.println("RETURN: " + current.getData());
        return current;
    }

    private void reverse_rec_bactrack(Node current) {

        if (current == null)
            return;
        Node next = current.getNext();
        reverse_rec_bactrack(next);
        if (next == null)
            return;
        next.setNext(current);
    }

    public boolean equals(LinkedList linkedList) {
        Node current1 = this.head;
        Node current2 = linkedList.head;
        while (current1 != null && current2 != null) {
            if ((current1.getData() != current2.getData()) ||
                    (current1 == this.tail && current2 != linkedList.tail) ||
                    (current2 == linkedList.tail && current1 != this.tail))
                return false;
            current1 = current1.getNext();
            current2 = current2.getNext();
        }
        return true;
    }

    public void destruct() throws Throwable {
        head = null;
        tail = null;
        super.finalize();
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

}

/**
 * Assume we have list: 1 2 3 4 5 6 7 8
 * 
 * If we call f(), what is the last value for cnt variable before a crash?
 * 
 * void f() {
 * int cnt = 0;
 * while(head) {
 * ++cnt;
 * cout<<cnt<<flush<<"\n";
 * head->data += head->next->next->next->data;
 * head = head->next;
 * }
 * }
 */