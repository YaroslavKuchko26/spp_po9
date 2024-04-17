package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomCharArray array = new CustomCharArray(List.of('a', 'b', 'b', 'c'));
        System.out.println("array:");
        System.out.println(array);
        System.out.println();

        System.out.println("array.add('f')");
        array.add('f');
        System.out.println(array);
        System.out.println();

        System.out.println("array.remove('c')");
        array.remove('c');
        System.out.println(array);
        System.out.println();

        System.out.println("array.contains('c')");
        System.out.println(array.contains('c'));
        System.out.println();

        System.out.println("array.contains('f')");
        System.out.println(array.contains('f'));
        System.out.println();

        CustomCharArray array1 = new CustomCharArray(List.of('b', 'b', 'b', 'a'));
        System.out.println("array1:");
        System.out.println(array1);
        System.out.println();

        System.out.println("array.intersection(array1)");
        System.out.println(array.intersection(array1));
        System.out.println();

        System.out.println("array.equals(array1)");
        System.out.println(array.equals(array1));
        System.out.println();

        CustomCharArray array2 = new CustomCharArray(List.of('a', 'b', 'b', 'f'));
        System.out.println("array2:");
        System.out.println(array2);
        System.out.println();

        System.out.println("array.equals(array2)");
        System.out.println(array.equals(array2));
        System.out.println();
    }
}