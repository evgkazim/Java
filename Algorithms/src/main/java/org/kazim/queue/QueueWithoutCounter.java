package org.kazim.queue;

/**
 * Очередь без счетчика элементов <br>
 * Вставка и извлечение элементов очереди, как и элементов стека, выполняются за время O(1).
 */
public class QueueWithoutCounter {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public QueueWithoutCounter(int s) {
        maxSize = s + 1;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    /**
     * Вставка элемента в конец очереди
     * @param j
     */
    public void insert(long j) {
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = j;
    }

    /**
     * Извлечение элемента в начале очереди
     * @return
     */
    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        return temp;
    }

    /**
     * Чтение элемента в начале очереди
     * @return
     */
    public long peek() {
        return queArray[front];
    }

    /**
     * @return true, если очередь пуста
     */
    public boolean isEmpty() {
        return (rear + 1 == front || (front + maxSize - 1 == rear));
    }

    /**
     * @return true, если очередь заполнена
     */
    public boolean isFull() {
        return (rear + 2 == front || (front + maxSize - 2 == rear));
    }

    /**
     * @return размер
     */
    public int size() {
        if (rear >= front) // Непрерывная последовательность
            return rear - front + 1;
        else // Несвязная последовательность
            return (maxSize - front) + (rear + 1);
    }
}
