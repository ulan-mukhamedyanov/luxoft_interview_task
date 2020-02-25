# Luxoft Interview Tasks

## Task 1:

1. Write a function/method that accepts a list of string tokens and a separate text string as an input and checks if the latter string can be represented as a concatenation of any subset of tokens from the first argument, where each token can be used multiple times. Examples:

```
[ "ab", "bc", "a" ] vs. "abc" =  true
[ "a", "ab", "bc" ] vs. "ab" =  true
[ "a", "ab", "bc" ] vs. "" =  true
[ "ab", "bc" ] <-> "abc" = false
[ "ab", "bc", "c" ] <-> "abbcbc" = true
```

2. Estimate the computational complexity of your code

3. Let's assume the list of tokens can be preprocessed somehow once, and then the result is to be multiple times applied to long input strings. E.g. in Golang notation:

```
func preprocess(tokens []string) func(input string) bool {
...
}

validator := preprocess(someTokens)
for _, input := range longListOfInputs {
  fmt.Printf("%s: %v\n", input, validator(input))
}
```

We don't care about preprocessor() performance much, but we want validator() to run as far as possible. Could you suggest any implementation that satisfies this extra requirement? if so, what's the computational complexity of that implementation?


## Task 2:

1. The input is a list of intervals (two integer points); write a function/method that merges any N intervals in the list that have common points (intervals [1, 3] and [3, 6] have a common point of 3; [4, 8] and [6, 10] have common points of 6, 7, 8) and returns the merged list (where no two intervals intersect). it is allowed to modify the input. Try to avoid allocating extra memory for the output.

```
[1, 4], [3, 7], [8, 10], [9, 11] –> [8, 11], [1,7]
[2, 4], [4, 6], [7, 9] –> [2, 6], [7, 9]
```

2. What is the computational complexity of your implementation?


## Solution guide

Solution code is located in ```src/main/java/com/jw/```.

Computational complexities are mentioned over corresponding methods in JavaDocs.

Unit test have been prepared for the solutions and are located in ```src/test/java/com/jw```.
