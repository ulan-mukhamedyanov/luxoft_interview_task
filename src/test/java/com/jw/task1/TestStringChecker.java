package com.jw.task1;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class TestStringChecker {

    @Test
    public void testCheckRandom() {

        final int nTokens = 50;
        final int maxTokenLen = 10;
        final int nTestStrings = 1000;
        final int maxTokensPerTestString = 20;
        final Random random = new Random();

        final String sourceString = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
        String[] tokens = new String[nTokens];

        for (int i = 0; i < nTokens; i ++) {
            StringBuilder sb = new StringBuilder();
            int tokenLen = random.nextInt(maxTokenLen) + 1;
            for (int j = 0; j < tokenLen; j++) {
                sb.append(sourceString.charAt(random.nextInt(sourceString.length())));
            }
            tokens[i] = sb.toString();
        }

        StringChecker stringChecker = new StringChecker(tokens);

        for (int i = 0; i < nTestStrings; i++) {
            int items = random.nextInt(maxTokensPerTestString) + 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < items; j++) {
                sb.append(tokens[random.nextInt(tokens.length)]);
            }
            String res = sb.toString();
            System.out.println(res);
            Assert.assertTrue(stringChecker.check(res));
        }

    }

    @Test
    public void testCheckPredefined() {

        String[] tokens = {"b", "ab", "ae", "ca", "cdea", "aecbae", "cde", "eee", "cad", "cae"};

        String[] correctStrings = {
                "caecaeeeabcdeabaeabaecbaecadcaaecbaeaecbaecaeaecbaecaecab",
                "caeaecbaebcdeaecbaecadaecbaecdecacaabbbcdecadaecbaeaecadeee",
                "eeecdeaaecbaeeeeaecbaecdeaeeeaebabeeeabaecbaecacaeb",
                "eeeaeaecbaeaeeeecacaecabcdeaecbaeeeebcaeaecaeeeeaeaecbae",
                "caeeeecdeacadbaecbaebcadae",
                "abcad",
                "cdeaeeecadaecbaecacaeae",
                "abaecbaecadcacdea",
                "caeaeabcdeacdeaeeeabaecdeabbcadcaecacdecacae",
                "eeeaeeeecadcdeacaecaeabcabaecdecacde",
                "ab",
                "aecaeeeecadcaecadeee",
                "caeaecbaecaecaabcadabaecbaeeee",
                "cabcdeaaeabcaecaecdeabcdeaaeabaeaecbaeaecbaecdeacdea",
                "caecaecaecaecdeacdeabcabcdeacdeaeeeb",
                "abcacdeaecdeacdeacadcdeaeeecaaebaebcdeeeeabcaecaaecbae",
                "aecbaecdeaeeebaecbaeaecbaebcdecdeaaebbaecbaeaeaebcae",
                "cdecadbaecbaeaeabeeebcdecacadaecbaecaaecdecaeeeca",
                "cdeaaeaecbaeaeabcdecdea",
                "cacdeaaecbaecdecdecaecacdeaecaab",
                "eeecdeacadabeeeaeabcaaecbaecadbaecbaeaecad",
                "caaecbaeaeaecbaecacadcadeeecaabcdecadaecbaebaecbaeaecaecaebb",
                "cdeaabae",
                "babbababeeecdeacaaeca",
                "abcdecadcacacdeacadaecbaecdeeeecaeab",
                "cdecaecdeacdeae",
                "caeeeecadcdecde",
                "aeabcdeacacdeabcdebbcadaebcaaecdebaecbaeeeeae",
                "bcadcaecdeacdecaaebeeeaecbaecaeeecdeacaecaeeeaecbaecdeaaecbaeeee",
                "baecbaecdeaecbaecae",
                "abaecbaeaecbaeaecadabab",
                "cdecaeaecbaecde",
                "cdeeeecadcdeacdeacdeaae",
                "bcaebeeecaeaeaeeeecabcaecaecaeaecdecaecadeeeaecbaeb",
                "aeabeeeaecbaecadbcadaecbaecadaecbaeabbbeeecdecad",
                ""
        };

        String[] wrongStrings = {
                "a",
                "aa",
                "aaa",
                "cada",
                "dada",
                "dadad",
                "aecbaeee",
                "eeeee",
                "abba",
                "acde"
        };

        StringChecker stringChecker = new StringChecker(tokens);

        Assert.assertTrue(stringChecker.check("cdeae"));
        for (String correctString : correctStrings) {
            Assert.assertTrue(stringChecker.check(correctString));
        }
        for (String str : wrongStrings) {
            Assert.assertFalse(stringChecker.check(str));
        }

    }

}
