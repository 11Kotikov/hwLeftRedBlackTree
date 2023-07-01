package org.example.model;

public class LeftRedBlackTree {
    public Node root;

    public void add(int key) {
        root = addNode(root, key);
        root.color = Color.BLACK;
    }

    private Node addNode(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.value) {
            node.leftChild = addNode(node.leftChild, key);
        } else if (key > node.value) {
            node.rightChild = addNode(node.rightChild, key);
        }

        if (node.rightChild != null && node.rightChild.color == Color.RED && (node.leftChild == null || node.leftChild.color == Color.BLACK)) {
            node = rotateLeft(node);
        }
        if (node.leftChild != null && node.leftChild.color == Color.RED && node.leftChild.leftChild != null && node.leftChild.leftChild.color == Color.RED) {
            node = rotateRight(node);
        }
        if (node.leftChild != null && node.leftChild.color == Color.RED && node.rightChild != null && node.rightChild.color == Color.RED) {
            flipColors(node);
        }

        return node;
    }

    private Node rotateLeft(Node node) {
        Node temp = node.rightChild;
        node.rightChild = temp.leftChild;
        temp.leftChild = node;
        temp.color = node.color;
        node.color = Color.RED;
        return temp;
    }

    private Node rotateRight(Node node) {
        Node temp = node.leftChild;
        node.leftChild = temp.rightChild;
        temp.rightChild = node;
        temp.color = node.color;
        node.color = Color.RED;
        return temp;
    }

    private void flipColors(Node node) {
        node.color = (node.color == Color.RED) ? Color.BLACK : Color.RED;
        node.leftChild.color = (node.leftChild.color == Color.RED) ? Color.BLACK : Color.RED;
        node.rightChild.color = (node.rightChild.color == Color.RED) ? Color.BLACK : Color.RED;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString();
    }

    private void inOrderTraversal(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild, sb);
        sb.append("[").append(node.value).append(":").append(node.color).append("] ");
        inOrderTraversal(node.rightChild, sb);
    }
}

