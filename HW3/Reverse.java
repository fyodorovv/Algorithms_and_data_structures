package org.example;

public class Reverse {
    private Node head;
    public void addFirst(int value){
        Node node = new Node();
        node.value = value;
        if (head != null){
            node.next = head;
        }
        head = node;
    }

    public  void reverseList(){
        if (head == null){
            return;
        }
        else {
            Node curr = head;
            Node prev = null;
            while (curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
    }

    public void print(){
        if (head == null){
            System.out.println("Пустой список");
            return;
        }
        Node node = head;
        while (node != null){
            System.out.print(node.value + " -> ");
            node = node.next;
        }
    }

    private class Node{
        private int value;
        private Node next;

    }
}

