package org.kazim.array;

import org.junit.jupiter.api.Test;


class HighArrayTest {
    int maxSize = 100;
    HighArray arr = new HighArray(maxSize);

    @Test
    void find() {
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        int searchKey = 35;
        if(arr.find(searchKey) != 0)
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);
        arr.delete(00);
        arr.delete(55);
        arr.delete(99);
        arr.display();
    }
}