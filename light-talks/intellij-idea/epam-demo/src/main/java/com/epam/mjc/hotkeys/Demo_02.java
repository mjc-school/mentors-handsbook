package com.epam.mjc.hotkeys;

public class Demo_02 {

    public static final int MULTIPLIER = 2;

    public static void main(String[] args) {
        int i = getInitialNumber(5);

        i = doCalculation(i);

        i = doCalculation(i);

        System.out.println(i);
    }

    private static int doCalculation(int variable) {
        if (variable > 0) {
            variable *= 2;
        } else {
            variable = 2;
        }
        return variable;
    }

    private static int getInitialNumber(int i) {
        return i * MULTIPLIER;
    }
}
