package org.it.svil.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("S");
        list.add("S");
        list.add("T");
        list.add("A");
        list.add("F");

        Set<String> set = (Set<String>) convertiSet(list);
        set.forEach(s->System.out.println(s));

    }

    public static Set<?> convertiSet(List<?> list) {
        return new TreeSet<>(list);
    }
}