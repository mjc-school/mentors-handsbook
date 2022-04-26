package com.epam.mjc.live.template;

import java.util.List;

public class Demo_01 {

    private static final List<String> STRINGS = List.of("a", "b", "c", "d");

    public static void main(String[] args) {
        for (String s : STRINGS) {
            System.out.println(s);
        }
    }
}
