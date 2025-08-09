package leetcode.strings;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String s = "([}}])";
        System.out.println("the provided string parenthesis is valid: " + valid(s));
    }

    public static boolean valid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            }
            else if (c == '{') {
                stack.push('}');
            }
            else if (c == '[') {
                stack.push(']');
            }

            else if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
            }
            else
                stack.push(c);

        }
        if (stack.isEmpty())
            return true;
        else
            return false;

    }
}
