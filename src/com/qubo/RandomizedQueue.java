package com.qubo;

import java.util.Iterator;

/**
 * Created by Qubo Song on 6/30/2014.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] queue;
    private int size;

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
    //TODO: resize the array queue[];
    }

    public void enqueue(Item item) {
    // add the item
        if (item == null) throw new NullPointerException("Cannot enqueue a null item.");

        if (size == queue.length) resize(2 * queue.length);
        queue[size++] = item;
    }

    public Item dequeue() {
    // delete and return a random item

    }

    public Item sample() {
    // return (but do not delete) a random item
    }

    public Iterator<Item> iterator() {
    // return an independent iterator over items in random order
    }

    public static void main(String[] args) {
    // unit testing
    }
}
