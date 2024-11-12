package com.example.project;

public interface Stack<T> {
    T pop();
    void push(T e);
    boolean empty();
    boolean full();
}
