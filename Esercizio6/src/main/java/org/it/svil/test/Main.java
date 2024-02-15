package org.it.svil.test;

public class Main {
    public static void main(String[] args) {
        int i=1;
        while(i<=20) {
            if(i%2==0 && i%3==0)
                System.out.println(Math.pow(i, 2));
            else
                System.out.println(Math.sqrt(i));
            i++;
        }
    }
}