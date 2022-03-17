package com.epam.mjc.inspections;

import java.util.ArrayList;
import java.util.List;

public class Demo_02 {

    public static void main(String[] args) {
        collections();
        strings();
    }

    private static void collections() {
        List<String> strings = List.of("a", "b", "c", "d");

        List<String> second = new ArrayList<>(strings);

        System.out.println(second);
    }

    private static void strings() {

        System.out.println("Hello World".repeat(10));
    }
}
