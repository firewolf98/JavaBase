package org.it.svil.test;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int n = 0;

        while (true) {
            if (n % 2 == 0) {
                System.out.println(n);
                count++;
            }
            if (count != 5) {
                n++;
                continue;
            }
            break;
        }
    }
}
