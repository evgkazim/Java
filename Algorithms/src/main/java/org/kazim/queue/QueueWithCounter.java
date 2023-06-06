package org.kazim.queue;

/**
 * Очередь с счетчиком элементов
 */
public class QueueWithCounter {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueWithCounter(int s) {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * Вставка элемента в конец очереди
     *
     * @param j
     */
    public void insert(long j) {
        if (rear == maxSize - 1) // Циклический перенос
            rear = -1;
        queArray[++rear] = j; // Увеличение rear и вставка
        nItems++; // Увеличение количества элементов
    }

    /**
     * Извлечение элемента в начале очереди
     *
     * @return
     */
    public long remove() {
        long temp = queArray[front++]; // Выборка и увеличение front
        if (front == maxSize) // Циклический перенос
            front = 0;
        nItems--; // Уменьшение количества элементов
        return temp;
    }

    /**
     * Чтение элемента в начале очереди
     *
     * @return
     */
    public long peekFront() {
        return queArray[front];
    }

    /**
     * @return true, если очередь пуста
     */
    public boolean isEmpty() {
        return (nItems == 0);
    }

    /**
     * @return true, если очередь заполнена
     */
    public boolean isFull() {
        return (nItems == maxSize);
    }

    /**
     * Количество элементов в очереди
     *
     * @return
     */
    public int size() {
        return nItems;
    }
}
