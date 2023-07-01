package org.example.model;

public class Node {
    public int value;
    Node leftChild;
    Node rightChild;
    Color color;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.color = Color.RED;
    }
}
