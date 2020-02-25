package com.jw.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringChecker {

    private Node root;
    private int minTokenLength;

    private static class Node {

        private Map<Character, Node> nextNodes;
        private boolean linkToRoot;

        public Node() {
            this.nextNodes = new HashMap<>();
            this.linkToRoot = false;
        }

        public boolean nodeExists(char c) {
            return nextNodes.containsKey(c);
        }

        public Node getNodeByKey(char c) {
            return nextNodes.get(c);
        }

        public Node createNodeForKey(char c) {
            Node newNode = new Node();
            nextNodes.put(c, newNode);
            return newNode;
        }

    }

    public StringChecker() {}

    public StringChecker(String[] tokens) {
        this();
        loadTokens(tokens);
    }

    /**
     * Generates a char tree for fast search.
     * Tree building time complexity for any case: O(m),
     * where m = total length of all tokens.
     */
    public void loadTokens(String[] tokens) {
        root = new Node();
        Node currentNode;
        for (String token : tokens) {
            currentNode = root;
            if (token.length() < minTokenLength || minTokenLength == 0)
                minTokenLength = token.length();
            for (int i = 0; i < token.length(); i++) {
                char c = token.charAt(i);
                Node newNode;
                if (!currentNode.nodeExists(c)) {
                    newNode = currentNode.createNodeForKey(c);
                } else {
                    newNode = currentNode.getNodeByKey(c);
                }
                if (i == token.length() - 1) {
                    newNode.linkToRoot = true;
                }
                currentNode = newNode;
            }
        }
    }

    /**
     * Traverses the tree searching for possibility of building the input string from the loaded tokens.
     * Checking time complexity for the worst case:
     * n = string length;
     * t = number of tokens (constant at this stage);
     * for t >= n: O(n^2 / 2) -> O(n^2);
     * for t < n: O(t(n - t) + t^2 / 2) -> O(t(2n - t)) -> O(n);
     */
    public boolean check(String string) {
        assert root != null;
        if (string.equals(""))
            return true;
        if (string.length() < minTokenLength)
            return false;
        int currentPosition = 0;
        Node currentNode = root;
        Stack<Integer> positionsToRoot = new Stack<>();
        while (true) {
            if (currentPosition == string.length()) {
                if (currentNode.linkToRoot) {
                    return true;
                } else if (!positionsToRoot.empty()) {
                    currentPosition = positionsToRoot.pop();
                    currentNode = root;
                    continue;
                } else {
                    return false;
                }
            }
            char c = string.charAt(currentPosition);
            if (currentNode.nodeExists(c)) {
                if (currentNode.linkToRoot) {
                    positionsToRoot.push(currentPosition);
                }
                currentNode = currentNode.getNodeByKey(c);
                currentPosition++;
                continue;
            } else {
                if (currentNode.linkToRoot) {
                    currentNode = root;
                    continue;
                } else if (!positionsToRoot.empty()) {
                    currentPosition = positionsToRoot.pop();
                    currentNode = root;
                    continue;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean check(String[] tokens, String testString) {
        loadTokens(tokens);
        return check(testString);
    }

}
