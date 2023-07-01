package org.example;

import org.example.model.LeftRedBlackTree;

public class Main {
    public static void main(String[] args) {
        LeftRedBlackTree tree = new LeftRedBlackTree();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(20);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(17);
        tree.add(888);
        tree.add(1);
        tree.add(100);
        tree.add(676);
        tree.add(6);
        tree.add(8);
        tree.add(203);
        System.out.println("Root: " + tree.root.value);
        System.out.println(tree);
    }
}