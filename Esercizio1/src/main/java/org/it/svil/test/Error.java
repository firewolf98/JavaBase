package org.it.svil.test;

import java.util.*;
import java.util.stream.Collectors;

public class Error {
    public static void main(String[] args) {
        String[] fruits = {"Apple", "Banana", "Cherry", "Date"};
        int index = getRandomIndex();

        try {
            System.out.println("Selected fruit: " + fruits[index]);
            int length = fruits[index].length();
            System.out.println("Length of the fruit name: " + length);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        }
    }

    public static int getRandomIndex() {
        return (int) (Math.random() * 5);
    }
}

