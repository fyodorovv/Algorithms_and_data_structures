package org.example;


public class RBT<V extends Comparable<V>> {
    private Node root;

    public boolean contains(V value) {
        Node node = root;
        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            if (node.value.compareTo(value) > 0) {
                node = node.leftPart;
            } else {
                node = node.rightPart;
            }
        }
        return false;
    }

    public boolean add(V value) {
        Node newNode = new Node();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            root.color = Color.Black;
            return true;
        } else {
            boolean result = addNode(root, value);
            root = balancing(root);
            root.color = Color.Black;
            return result;
        }
    }

    public boolean addNode(Node node, V value) {
        if (node.value.compareTo(value) == 0) {
            return false;
        } else {
            if (node.value.compareTo(value) > 0) {
                if (node.leftPart != null) {
                    boolean result = addNode(node.leftPart, value);
                    node.leftPart = balancing(node.leftPart);
                    return result;
                } else {
                    node.leftPart = new Node();
                    node.leftPart.color = Color.Red;
                    node.leftPart.value = value;
                    return true;
                }
            } else {
                if (node.rightPart != null) {
                    boolean result = addNode(node.rightPart, value);
                    node.rightPart = balancing(node.rightPart);
                    return result;
                } else {
                    node.rightPart = new Node();
                    node.rightPart.color = Color.Red;
                    node.rightPart.value = value;
                    return true;
                }
            }
        }
    }

    private void changeColor(Node node) {
        node.rightPart.color = Color.Black;
        node.leftPart.color = Color.Black;
        node.color = Color.Red;
    }

    private Node leftTurn(Node node) {
        Node leftPart = node.leftPart;
        Node between = leftPart.rightPart;
        leftPart.rightPart = node;
        node.leftPart = between;
        leftPart.color = node.color;
        node.color = Color.Red;
        return leftPart;
    }

    private Node rightTurn(Node node) {
        Node rightPart = node.rightPart;
        Node between = rightPart.leftPart;
        rightPart.leftPart = node;
        node.rightPart = between;
        rightPart.color = node.color;
        node.color = Color.Red;
        return rightPart;
    }

    private Node balancing(Node node) {
        Node result = node;
        boolean balanced;
        do {
            balanced = false;
            if (result.rightPart != null && result.rightPart.color == Color.Red && (result.leftPart == null || result.leftPart.color == Color.Black)) {
                balanced = true;
                result = rightTurn(result);
            }
            if (result.leftPart != null && result.leftPart.color == Color.Red && result.leftPart.leftPart != null && result.leftPart.leftPart.color == Color.Red) {
                balanced = true;
                result = leftTurn(result);
            }
            if (result.leftPart != null && result.leftPart.color == Color.Red && result.rightPart != null && result.rightPart.color == Color.Red) {
                balanced = true;
                changeColor(result);
            }
        }
        while (balanced);
        return result;
    }

    private class Node {
        private V value;
        private Node leftPart;
        private Node rightPart;
        private Color color;
    }

    private enum Color {
        Red, Black
    }
}

//    @Override
//    public  String toString(){
//        return "Node{" + "value=" + value + ", color=" + color + "}";
//    }

