package com.example.project;

public interface Queue<T> {
    T serve();
    void enqueue(T e);
    int length();
    boolean full();
}
