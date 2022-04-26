package com.epam.mjc.hotkeys;

import java.io.*;

public class Demo_03 {

    public static void main(String[] args) throws FileNotFoundException {
        DataOutputStream stream = new DataOutputStream(new FileOutputStream("someFile.txt"));
        new BufferedOutputStream(stream);

        Object o = new Object();
        o.toString().substring(0, 1);
    }
}
