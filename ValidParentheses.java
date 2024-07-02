/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.*/

import java.util.Stack;

class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (isOpening(current)) {
                s.push(current);
            } else {
                if (s.isEmpty()) {
                    return false;
                } else if (!isMatching(s.peek(), current)) {
                    return false;
                } else {
                    s.pop();
                }
            }
        }
        return s.isEmpty();
    }

    boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    boolean isMatching(char a, char b) {
        return (a == '(' && b == ')') ||
               (a == '{' && b == '}') ||
               (a == '[' && b == ']');
    }
}
