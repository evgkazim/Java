package org.kazim.array;

public class ObjectDataArray {
    private Person[] a;
    private int nElems;

    public ObjectDataArray(int max) {
        a = new Person[max];
        nElems = 0;
    }

    public Person find(String searchName) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j].getLast().equals(searchName))
                break;
        if (j == nElems)
            return null;
        else
            return a[j];
    }

    public void insert(String last, String first, int age) {
        a[nElems] = new Person(last, first, age);
        nElems++;
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j].getLast().equals(searchName))
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

    public void displayA() {
        for (int j = 0; j < nElems; j++)
            a[j].displayPerson();
    }

    class Person {
        private String lastName;
        private String firstName;
        private int age;

        public Person(String last, String first, int a) {
            lastName = last;
            firstName = first;
            age = a;
        }

        public void displayPerson() {
            System.out.print(" Last name: " + lastName);
            System.out.print(", First name: " + firstName);
            System.out.println(", Age: " + age);
        }

        public String getLast() {
            return lastName;
        }
    }
}
