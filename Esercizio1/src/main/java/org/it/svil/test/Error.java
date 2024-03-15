package org.it.svil.test;

import java.util.*;

public class Error {
    public static void main(String[] args)  {
        List<String> strings = Arrays.asList("Pippo","Pluto", "Topolino", "Minnie", "Paperino");

        String valricercato = "Topolino";

        System.out.println(strings.stream().filter(s->s.contains(valricercato)).count()>0?"Trovato":"Non trovato");
    }

}

