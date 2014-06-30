import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;

    private class Node {
        private Item item;
        private Node previous, next;

        public Node(Item item) {
            this.item = item;
            previous = next = null;
        }
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current == null;
        }

        public void remove() {
            throw new UnsupportedOperationException("This method is not supported in Iterator.");
        }

        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException("There's no more element.");

            current = current.next;
            return current.previous.item;
        }
    }

    public Deque() {
    // construct an empty deque
        first = last = null;
        size = 0;
    }

    public boolean isEmpty() {
    // is the deque empty?
        return (size == 0);
    }

    public int size() {
    // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item) {
    // insert the item at the front
        if (item == null) throw new NullPointerException("Cannot add a null item.");

        Node oldFirst = first;
        first = new Node(item);

        if (isEmpty()) {
            last = first;
        } else {
            first.next = oldFirst;
            oldFirst.previous = first;
        }

        size++;
    }

    public void addLast(Item item) {
    // insert the item at the end
        if (item == null) throw new NullPointerException("Cannot add a null item.");

        Node oldLast = last;
        last = new Node(item);

        if (isEmpty()) {
            first = last;
        } else {
            last.previous = oldLast;
            oldLast.next = last;
        }

        size++;
    }

    public Item removeFirst() {
    // delete and return the item at the front
        if (isEmpty()) throw new java.util.NoSuchElementException("Nothing to remove at the front.");

        Node oldFirst = first;
        first = oldFirst.next;
        if (first != null) first.previous = null;
        oldFirst.next = null;
        size--;

        return oldFirst.item;
    }

    public Item removeLast() {
    // delete and return the item at the end
        if (isEmpty()) throw new java.util.NoSuchElementException("Nothing to remove at the front.");

        Node oldLast = last;
        last = oldLast.previous;
        if (last != null) last.next = null;
        oldLast.previous = null;
        size--;

        return oldLast.item;
    }

    public Iterator<Item> iterator() {
    // return an iterator over items in order from front to end
        return new DequeIterator();
    }

    public static void main(String[] args) {
    // unit testing

        System.out.print("Testing main.Deque...\n\n");
        System.out.print("Initializing... ");
        Deque<Integer> test = new Deque<Integer>();
        System.out.print("finished.\n");

        System.out.printf("Size of newly initialized main.Deque is: %d ... ", test.size());
        if (test.size() == 0) {
            System.out.print("CORRECT.\n\n");
        } else {
            System.out.print("WRONG.\n\n");
        }

        int in, out;
        in = 1;
        System.out.print("addFirst(in)... ");
        test.addFirst(in);
        System.out.print("done.\n");
        System.out.printf("Size expected: 1. Actual: %d ... ", test.size());
        if (test.size() == 1) {
            System.out.print("CORRECT.\n\n");
        } else {
            System.out.print("WRONG.\n\n");
        }

        System.out.print("removeFirst()... ");
        out = test.removeFirst();
        System.out.print("done.\n");
        System.out.printf("Node value expected: %d. Actual: %d ... ", in, out);
        if (in == out) {
            System.out.print("CORRECT.\n");
        } else {
            System.out.print("WRONG.\n");
        }
        System.out.printf("Size expected: 0. Actual: %d ... ", test.size());
        if (test.size() == 0) {
            System.out.print("CORRECT.\n\n");
        } else {
            System.out.print("WRONG.\n\n");
        }
    }
}
