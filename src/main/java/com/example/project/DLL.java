package com.example.project;

public class DLL<T> implements List<T> {
    private DLLNode<T> head;
    private DLLNode<T> current;
    private int size;

    public DLL() {
        head = current = null;
        size = 0;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current != null && current.next == null;
    }

    public boolean first() {
        return current != null && current.previous == null;
    }

    public boolean full() {
        return false; // Doubly linked list is dynamically sized
    }

    public int size() {
        return size;
    }

    public void findFirst() {
        current = head;
    }

    public void findNext() {
        if (current != null) current = current.next;
    }

    public void findPrevious() {
        if (current != null) current = current.previous;
    }

    public T retrieve() {
        return current != null ? current.data : null;
    }

    public void update(T val) {
        if (current != null) current.data = val;
    }

    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<>(val);
        if (empty()) {
            current = head = tmp;
        } else {
            tmp.next = current.next;
            tmp.previous = current;
            if (current.next != null) current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
        size++;
    }

    public void remove() {
        if (current == head) {
            head = head.next;
            if (head != null) head.previous = null;
        } else if (current != null) {
            current.previous.next = current.next;
            if (current.next != null) current.next.previous = current.previous;
        }
        if (current != null) current = current.next != null ? current.next : head;
        size--;
    }

    // Implementation of removeBetween method as per provided instructions
    public void removeBetween(T e1, T e2) {
        DLLNode<T> p = head;
        while (p != null && !p.data.equals(e1)) p = p.next;
        if (p == null) return;

        DLLNode<T> q = p.next;
        while (q != null && !q.data.equals(e2)) q = q.next;
        if (q == null) return;

        p.next = q;
        q.previous = p;
        current = head; // Move current to head after successful removal
    }
}
