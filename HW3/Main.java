package org.example;

public class Main {
    public static void main(String[] args) {
        Reverse list = new Reverse();
        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(5);
        list.addFirst(7);
        list.print();
        System.out.println();
        list.reverseList();
        list.print();
        System.out.println();

    }
}