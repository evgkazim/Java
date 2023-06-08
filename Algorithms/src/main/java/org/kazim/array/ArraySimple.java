package org.kazim.array;

/**
 * Обычный массив
 */
public class ArraySimple {
    private long[] a;
    private int nElems;

    public ArraySimple(int max) {
        this.a = new long[max];
        this.nElems = 0;
    }

    /**
     * Линейный поиск
     *
     * @param searchKey
     * @return
     */
    public int find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] == searchKey)
                break;
        if (j == nElems)
            return 0;
        else
            return j;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (value == a[j])
                break;
        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }

    /**
     * Пузырьковая сортировка
     */
    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--)      // Внешний цикл (обратный)
            for (in = 0; in < out; in++)            // Внутренний цикл (прямой)
                if (a[in] > a[in + 1])              // Порядок нарушен?
                    swap(in, in + 1);          // Поменять местами
    }
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    /**
     * Сортировки методом вставки
     */
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {        // out - разделительный маркер
            long temp = a[out];                     // Скопировать помеченный элемент
            in = out;                               // Начать перемещения с out
            while (in > 0 && a[in - 1] >= temp) {   // Пока не найден меньший элемент
                a[in] = a[in - 1];                  // Сдвинуть элемент вправо
                --in;                               // Перейти на одну позицию влево
            }
            a[in] = temp;                           // Вставить помеченный элемент
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }

    public long[] getA() {
        return a;
    }
}
