package com.jw.task1;

public class App {

    public static void main(String[] args) {

        StringChecker checker = new StringChecker();

        String[] tokens1 = {"ab", "bc", "a"};
        String testTokens1String1 = "";
        String testTokens1String2 = "ab";
        String testTokens1String3 = "abc";

        String[] tokens2 = {"ab", "bc"};
        String testTokens2String = "abc";

        String[] tokens3 = {"ab", "bc", "c"};
        String testTokens3String = "abbcbc";

        checker.loadTokens(tokens1);
        System.out.println(checker.check(testTokens1String1));              // true
        System.out.println(checker.check(testTokens1String2));              // true
        System.out.println(checker.check(testTokens1String3));              // true

        System.out.println(checker.check(tokens2, testTokens2String));      // false

        System.out.println(checker.check(tokens3, testTokens3String));      // true

    }

}
