package com.algorithm.linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制特殊的链表
 */
public class question9 {
    private class Node{
        public Integer value;
        public Node next;
        public Node random;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public Node copyNode1(Node head){
        Node current = head;
        Map<Node,Node> map = new HashMap<Node, Node>();
        while (current != null){
            map.put(current, new Node(current.value));
            current = current.next;
        }
        current = head;
        while (current != null){
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }

    public Node copyNode2(Node head){
        Node current = head;
        Node next = null;
        while (current != null){
            next = current.next;
            current.next = new Node(current.value);
            current.next.next = next;
            current = next;
        }
        current = head;
        while (current != null){
            next = current.next.next;
            current.next.random = current.random.next;
            current = next;
        }
        Node res = head.next;
        Node copy = null;
        current = head;
        while (current != null){
            next = current.next.next;
            copy = current.next;
            current.next = next;
            copy.next = next.next;
            current = next;
        }
        return res;
    }
}
