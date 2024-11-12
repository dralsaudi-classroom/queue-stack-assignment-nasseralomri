package com.example.project;

public class QueueStackTester {

    // Split a queue into odd and even positioned elements
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {
        recSplit(q, oq, eq, q.length(), 1);
    }

    private static <T> void recSplit(Queue<T> q, Queue<T> oq, Queue<T> eq, int count, int pos) {
        if (pos > count) return;

        T element = q.serve();
        q.enqueue(element); // Reinsert to maintain the original queue

        if (pos % 2 == 1) {
            if (!oq.full()) oq.enqueue(element); // Odd-positioned element
        } else {
            if (!eq.full()) eq.enqueue(element); // Even-positioned element
        }

        recSplit(q, oq, eq, count, pos + 1);
    }

    // Remove elements in priority queue with priority less than p
    public static <T> void remove(LinkedPQ<T> pq, int p) {
        LinkedPQ<T> tempPQ = new LinkedPQ<>();
        int count = pq.length();

        for (int i = 0; i < count; i++) {
            PQElement<T> element = pq.serve();
            if (element.p >= p) tempPQ.enqueue(element.data, element.p);
        }

        while (tempPQ.length() > 0) {
            PQElement<T> element = tempPQ.serve();
            pq.enqueue(element.data, element.p);
        }
    }

    // Recursive search method for stack
    public static <T> boolean search(Stack<T> st, T e) {
        if (st.empty()) return false;
        T top = st.pop();
        boolean found = top.equals(e) || search(st, e);
        st.push(top); // Restore original stack
        return found;
    }
}
