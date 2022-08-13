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
