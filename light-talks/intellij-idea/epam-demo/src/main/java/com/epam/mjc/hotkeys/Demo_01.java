package com.epam.mjc.hotkeys;

public class Demo_01 {

    public static void main(String[] args) {
        SomeClass someVar = new SomeClass();

        new Object();
        System.out.println(someVar.method2());
    }

    private static class SomeClass {

        public int method2() {
            return 1;
        }
    }
}
