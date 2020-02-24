package com.jw.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CharSearchGraph {

    private Node root;

    static class Node {

        private Map<Character, Node> nextNodes;
        private boolean returnToRoot;

        public Node() {
            this.nextNodes = new HashMap<>();
            this.returnToRoot = false;
        }

        public boolean isNext(char c) {
            return nextNodes.containsKey(c);
        }

        public Node getNext(char c) {
            return nextNodes.get(c);
        }

        public Node setNext(char c) {
            Node newNode = new Node();
            nextNodes.put(c, newNode);
            return newNode;
        }

    }

    public CharSearchGraph(String[] tokens) {
        root = new Node();
        Node currentNode;
        for (String token : tokens) {
            currentNode = root;
            for (int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                Node newNode;
                if (!currentNode.isNext(c)) {
                    newNode = currentNode.setNext(c);
                } else {
                    newNode = currentNode.getNext(c);
                }
                if (i == token.length() - 1) {
                    newNode.returnToRoot = true;
                }
                currentNode = newNode;
            }
        }
    }

    public boolean check(String string) {
        if (string.equals(""))
            return true;
        int currentPosition = 0;
        Node currentNode = root;
        Stack<Integer> positionsToRoot = new Stack<>();
        while (true) {
            if (currentPosition == string.length())
                if (currentNode.returnToRoot) {
                    return true;
                } else if (!positionsToRoot.empty()) {
                    currentPosition = positionsToRoot.pop();
                    currentNode = root;
                    continue;
                } else {
                    return false;
                }
            char c = string.charAt(currentPosition);
            if (currentNode.isNext(c)) {
                if (currentNode.returnToRoot) {
                    positionsToRoot.push(currentPosition);
                }
                currentNode = currentNode.getNext(c);
                currentPosition++;
                // continue;
            } else {
                if (currentNode.returnToRoot) {
                    currentNode = root;
                    // continue;
                } else if (!positionsToRoot.empty()) {
                    currentPosition = positionsToRoot.pop();
                    currentNode = root;
                    // continue;
                } else {
                    return false;
                }
            }
        }
    }

}
