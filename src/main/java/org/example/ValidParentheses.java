package org.example;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()[]{}"));
    }

    // O (N)
    // Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case,
    // we will end up pushing all the brackets onto the stack. e.g. ((((((((((.

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // Basicamente, pra cada caractere do array, irei colocar o caractere de fechamento em uma pilha
        // SE o caractere for de fechamento, vou verificar se o topo da minha pilha é igual
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

/*

Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.



* */