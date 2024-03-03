package vector;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Vector v = new Vector(2);

        v.push_back(4);
        v.push_back(0);
        v.push_back(1);
        v.push_back(2);
        v.push_back(3);

        v.print();

        // v.rotateRight(2);
        // int poped = v.pop(2);
        // System.out.println("POPPED: " + poped);

        int index = v.findTransposition(1);
        System.out.println("INDEX: " + index);
        v.print();

    }
}
