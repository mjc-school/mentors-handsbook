package com.epam.mjc.inspections;

import java.util.Scanner;

public class Demo_03 {

    public static void main(String[] args) {
        boolean bool = Boolean.parseBoolean(new Scanner(System.in).next());
        System.out.println(doComputations(bool));
    }

    @SuppressWarnings("uncheckedCast")
    private static boolean doComputations(boolean bool) {
        if (bool == false) {
            return true;
        } else {
            return false;
        }
    }
}
