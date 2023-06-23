package org.example;

public class Main {
    public static void main(String[] args) {
        RBT <Integer> tree = new RBT<>();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(1);
        System.out.println(tree);
    }
}