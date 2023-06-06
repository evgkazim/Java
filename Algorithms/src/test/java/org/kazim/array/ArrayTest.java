package org.kazim.array;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArrayTest {
    static int maxSize = 10001;
    static HighArray a1 = new HighArray(maxSize);
    static OrdArray a2 = new OrdArray(maxSize);
    static ArrayList<Long> a3 = new ArrayList<>();

    @BeforeAll
    static void setup() {
        File file = new File("nums.txt");
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    a1.insert(Long.parseLong(line));
                    a2.insert(Long.parseLong(line));
                    a3.add(Long.parseLong(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void a1() {
        a1.find(459);
        a1.delete(459);
        a1.insert(459);
    }

    @Test
    void a2() {
        a2.find(459);
        a2.delete(459);
        a2.insert(459);
    }

    @Test
    void a3() {
        a3.stream().filter(f -> f == 459).findFirst().orElse(0L);
        a3 = (ArrayList<Long>) a3.stream().filter(f -> f != 459).collect(Collectors.toList());
        a3.add(459L);
    }
}
