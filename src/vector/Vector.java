package vector;

/**
 * Vector
 */
public class Vector {

    private int size;

    private int[] arr;

    private int capacity;

    public Vector(int initialCapacity) {
        this.size = 0;
        this.capacity = initialCapacity > 0 ? initialCapacity * 2 : 10;
        this.arr = new int[capacity];
    }

    public int size() {
        return this.size;
    }

    public int[] push_back(int element) {
        if (size >= capacity)
            expandCapacity();
        arr[size] = element;
        size++;
        return arr;
    }

    public int[] insert(int index, int element) {
        if (size + 1 >= capacity)
            expandCapacity();
        for (int i = size - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
            if (i == index) {
                arr[i] = element;
                break;
            }
        }
        this.size++;
        return arr;
    }

    public int pop(int index) {
        int poped = arr[index];
        for (int i = index; i <= size - 2; i++)
            arr[i] = arr[i + 1];
        this.size--;
        return poped;
    }

    public int findTransposition(int value) {
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] == value) {
                if (i == 0)
                    return 0;
                swap(i, i - 1);
                return i - 1;
            }
        }
        return -1;
    }

    public void rotateRight(int times) {
        // every '%SIZE%' rotations arr wil be in it's original state before rotating
        times %= this.size;
        while (times > 0) {
            int element = arr[size - 1];
            for (int i = size - 2; i >= 0; i--) {
                arr[i + 1] = arr[i];
            }
            arr[0] = element;
            times--;
        }
    }

    public void rotateLeft() {
        int tail = arr[0];
        for (int i = 0; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = tail;
    }

    private void expandCapacity() {
        this.capacity *= 2;
        int[] expanded = new int[capacity];
        for (int i = 0; i < this.arr.length; i++)
            expanded[i] = this.arr[i];
        this.arr = expanded;
    }

    public int[] getElements() {
        int[] mirror = new int[size];
        for (int i = 0; i < size; i++)
            mirror[i] = arr[i];
        return mirror;
    }

    private void swap(int i, int j) {
        int temp = this.arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print() {
        for (int e : getElements()) {
            System.out.print(e + " ");
        }
        System.out.println();
        System.out.println("--------------------");
    }

}