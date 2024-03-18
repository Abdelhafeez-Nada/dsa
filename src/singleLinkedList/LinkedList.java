package singleLinkedList;

import java.util.HashSet;
import java.util.Set;
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

    public void insertLast(int... values) {
        for (int value : values) {
            // first node
            if (head == null) {
                head = new Node(value);
                tail = head;
                continue;
            }
            tail.setNext(new Node(value));
            tail = tail.getNext();
        }
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

    public void insertAlternate(LinkedList another) {
        if (another.getHead() == null)
            return;
        Node curr1 = this.getHead();
        Node curr2 = another.getHead();
        Node nex1 = curr1;
        Node nex2 = curr2;
        while (curr1 != null && curr2 != null) {
            nex1 = curr1.getNext();
            nex2 = curr2.getNext();
            curr1.setNext(curr2);
            curr2.setNext(nex1);
            curr1 = nex1;
            curr2 = nex2;
        }
        if (curr1 == null)
            this.tail = another.getTail();
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

    public void removeDuplicates_enhanced() {
        Node current = head;
        Set<Integer> uniques = new HashSet<>();
        while (current != null) {
            uniques.add(current.getData());
        }
        this.head = null;
        for (int n : uniques) {
            if (head == null) {
                head = new Node(n);
                this.tail = head;
                continue;
            }
            tail.setNext(new Node(n));
            tail = tail.getNext();
        }
    }

    /*
     * last = tail;
     * last = head;
     * head < last < tail
     */

    public void removeLastOccurance(int key) {
        Node current = head;
        Node last = null;
        while (current != null) {
            if (current.getData() == key)
                last = current;
            current = current.getNext();
        }
        if (last == head) {
            head = head.getNext();
            return;
        }
        current = head;
        while (current.getNext() != last)
            current = current.getNext();
        if (last == tail) {
            current.setNext(null);
            tail = current;
            return;
        }
        current.setNext(last.getNext());
    }

    public void moveBack(int key) {
        Node current = head;
        Node newTail = tail;
        Node previous = head;
        while (current != tail) {
            if (current.getData() == key) {
                if (current == head) {
                    newTail = head;
                    head = head.getNext();
                    current = head;
                    previous = head;
                    tail.setNext(newTail);
                    newTail.setNext(null);
                    tail = newTail;
                    continue;
                }
                newTail = current;
                current = current.getNext();
                previous.setNext(current);
                tail.setNext(newTail);
                newTail.setNext(null);
                tail = newTail;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public void removeDuplicates() {
        Node current = head;
        Node temp = null;
        Node previous = null;
        while (current != null) {
            temp = current.getNext();
            previous = current;
            while (temp != null) {
                if (temp.getData() == current.getData()) {
                    if (temp == tail) {
                        previous.setNext(null);
                        tail = previous;
                        break;
                    }
                    previous.setNext(temp.getNext());
                    temp = previous.getNext();
                    continue;
                }
                previous = temp;
                temp = temp.getNext();
            }
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

    public int getMax() {
        Node temp = head.getNext();
        int max = head.getData();

        return backtrackMax(temp, max);
    }

    public int backtrackMax(Node temp, int max) {
        if (temp == null)
            return max;
        return backtrackMax(temp.getNext(), Math.max(max, temp.getData()));
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

    public void swapHeadAndTail() throws InterruptedException {
        if (head == null || head == tail)
            return;
        if (head.getNext() == tail) {
            head.setNext(null);
            tail.setNext(head);
        } else {
            Node afterHead = head.getNext();
            Node beforeTail = head;
            while (beforeTail.getNext() != tail)
                beforeTail = beforeTail.getNext();
            head.setNext(null);
            beforeTail.setNext(head);
            tail.setNext(afterHead);
        }
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void reArrangeOddAndEven_enhanced() {

        Node odd = head;
        Node evenHead = head.getNext();
        Node even = evenHead;

        // 1 2 3 4 5
        while (even != null && even.getNext() != null) {
            odd.setNext(even.getNext());
            odd = odd.getNext();
            if (odd.getNext() == null)
                break;
            even.setNext(odd.getNext());
            even = even.getNext();
        }

        odd.setNext(evenHead);

        this.tail = even != null ? even : odd;
        tail.setNext(null);

    }

    public void reArrangeOddAndEven() {
        if (head == null || head == tail || head.getNext() == tail)
            return;
        Node odd = head;
        Node even;

        LinkedList temp = new LinkedList();
        while (odd.getNext() != null) {
            even = odd.getNext();
            System.out.println("Odd: " + odd.getData() + " Even: " + even.getData());
            temp.insertLast(even.getData());
            odd.setNext(even.getNext());
            if (even == tail) {
                tail = odd;
                break;
            }
            odd = odd.getNext();

        }
        this.tail = odd;
        System.out.println(temp.getHead());
        System.out.println(this.tail);
        this.tail.setNext(temp.getHead());
        this.tail = temp.getTail();
    }

    public void leftRotate(int k) {
        Node newHead = null;
        while (k > 0) {
            newHead = head.getNext();
            tail.setNext(head);
            head.setNext(null);
            tail = head;
            head = newHead;
            k--;
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