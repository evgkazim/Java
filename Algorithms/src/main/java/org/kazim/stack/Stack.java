package org.kazim.stack;

/**
 * Стек
 */
public class Stack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    /**
     * Инициализация стека
     *
     * @param s длина стека
     */
    public Stack(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    /**
     * Размещение на вершине стека
     *
     * @param j
     */
    public void push(long j) {
        stackArray[++top] = j;
    }

    /**
     * Извлечение элемента с вершины стека
     *
     * @return
     */
    public long pop() {
        return stackArray[top--];
    }

    /**
     * Чтение элемента с вершины стека
     *
     * @return
     */
    public long peek() {
        return stackArray[top];
    }

    /**
     * @return true, если стек пуст
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * @return true, если стек полон
     */
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
