package org.it.svil.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>(generaMappa("E","C","F","A","H","A","L","P","Z"));
        map.forEach((k,v)->System.out.println("Chiave: "+k+" Valore: "+v));
    }

    public static Map<Integer,String> generaMappa(String...args) {
        Arrays.sort(args);
        Map<Integer,String> map= new HashMap<>();
        for(int i=0;i< args.length;i++)
            map.put(i+1,args[i]);
        return map;
    }
}