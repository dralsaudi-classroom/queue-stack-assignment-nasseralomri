package com.example.project;

public class ArrayList<T> implements List<T> {
    private int maxsize;
    private int size;
    private int current;
    private T[] nodes;

    @SuppressWarnings("unchecked")
    public ArrayList(int n) {
        maxsize = n;
        size = 0;
        current = -1;
        nodes = (T[]) new Object[n];
    }

    public boolean full() {
        return size == maxsize;
    }

    public boolean empty() {
        return size == 0;
    }

    public boolean last() {
        return current == size - 1;
    }

    public void findFirst() {
        current = 0;
    }

    public void findNext() {
        if (current < size - 1) current++;
    }

    public T retrieve() {
        if (current < 0 || current >= size) throw new IllegalStateException("Invalid current position.");
        return nodes[current];
    }

    public void update(T val) {
        if (current < 0 || current >= size) throw new IllegalStateException("Invalid current position.");
        nodes[current] = val;
    }

    public void insert(T val) {
        if (full()) throw new IllegalStateException("ArrayList is full. Cannot insert new element.");
        for (int i = size - 1; i > current; --i) nodes[i + 1] = nodes[i];
        current++;
        nodes[current] = val;
        size++;
    }

    public void remove() {
        if (current < 0 || current >= size) throw new IllegalStateException("Invalid current position.");
        for (int i = current + 1; i < size; i++) nodes[i - 1] = nodes[i];
        size--;
        if (size == 0) current = -1;
        else if (current == size) current = 0;
    }
}
