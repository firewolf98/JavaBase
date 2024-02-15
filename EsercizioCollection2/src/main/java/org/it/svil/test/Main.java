package org.it.svil.test;

import org.it.svil.model.Film;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Film> movie = new ArrayList<>();
        movie.add(new Film("Il padrino",1979));
        movie.add(new Film("Il padrino II",1980));
        movie.add(new Film("Il padrino III",1981));
        movie.add(new Film("Fuga da Alcatraz",1979));
        movie.add(new Film("Rocky II",1979));
        movie.add(new Film("Rambo 2",1985));
        movie.add(new Film("Stalker",1979));
        movie.add(new Film("Scarface",1983));
        movie.add(new Film("Titanic",1998));
        movie.add(new Film("Via col vento",1951));
        movie.add(new Film("Star wars I",1977));
        movie.add(new Film("Oltre il giardino",1979));

        List<Film> film1979 = dammiFilm1979(movie);

        for(Film f: film1979)
            System.out.println(f);

        String[] soloTitolo = dammiFilm1979SoloTitolo(movie);
        for(String titolo: soloTitolo)
            System.out.println("Film["+ titolo + "]");
    }

    public static List<Film> dammiFilm1979(List<Film> list) {
        List<Film> list1 = new ArrayList<>();
        for(Film f: list)
            if(f.getYear()==1979)
                list1.add(f);
        return list1;
    }

    public static String[] dammiFilm1979SoloTitolo(List<Film> list) {
        List<Film> list1 = new ArrayList<>();
        for(Film f: list)
            if(f.getYear()==1979)
                list1.add(f);
        String[] list2 = new String[list1.size()];
        for(int i=0;i<list1.size();i++) {
            list2[i] = list1.get(i).getTitolo();
        }
        return list2;
    }
}