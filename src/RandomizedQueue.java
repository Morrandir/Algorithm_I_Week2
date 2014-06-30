import java.util.Iterator;

/**
 * Created by Qubo Song on 6/30/2014.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size;

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Item[] queueIterator;
        private int current = size;

        public RandomizedQueueIterator() {
            queueIterator = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                queueIterator[i] = queue[i];
            }
            StdRandom.shuffle(queueIterator);
        }

        @Override
        public boolean hasNext() {
            return (current > 0);
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException("There's no more element.");
            return queueIterator[--current];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("This method is not supported in Iterator.");
        }
    }
    public RandomizedQueue() {
    // construct an empty randomized queue
        queue = (Item[]) new Object[1];
        size = 0;
    }

    public boolean isEmpty() {
    // is the queue empty?
        return (size == 0);
    }

    public int size() {
    // return the number of items on the queue
        return size;
    }

    private void resize(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    private void swap(Item[] queue, int a, int b) {
        Item temp = queue[a];
        queue[a] = queue[b];
        queue[b] = temp;
    }

    public void enqueue(Item item) {
    // add the item
        if (item == null) throw new NullPointerException("Cannot enqueue a null item.");

        if (size == queue.length) resize(2 * queue.length);
        queue[size] = item;
        swap(queue, StdRandom.uniform(size + 1), size++);
    }

    public Item dequeue() {
    // delete and return a random item
        if(isEmpty()) throw new java.util.NoSuchElementException("Nothing to dequeue.");
        Item temp = queue[--size];
        queue[size] = null;
        if (size > 0 && size == queue.length / 4) resize(queue.length / 2);
        return temp;
    }

    public Item sample() {
    // return (but do not delete) a random item
        if(isEmpty()) throw new java.util.NoSuchElementException("Nothing to sample.");
        return queue[StdRandom.uniform(size)];
    }

    public Iterator<Item> iterator() {
    // return an independent iterator over items in random order
        return new RandomizedQueueIterator();
    }

    public static void main(String[] args) {
    // unit testing
    }
}
