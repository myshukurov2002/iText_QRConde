package org.example;

public class Main3 {
    public static void main(String[] args) {
        String str = "%s oferta yuridik %s shartnoma %s";
        str = String.format(str, "salom", "salom");
        String arr [] = new String[4];
        str = String.format(str, "salom", "salom");
        str = String.format(str, arr);
        System.out.println("str = " + str);
    }
}
