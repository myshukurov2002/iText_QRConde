package org.example;

public class Test {
    public static void main(String[] args) {
        String str = "%name MINISTRY OF HIGHER AND SECONDARY %ageSPECIALIZED EDUCATION";

        str = String.format("%name", "Ali", str);


        System.out.println(str);
    }
}
