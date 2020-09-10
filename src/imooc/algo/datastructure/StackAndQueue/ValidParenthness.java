package imooc.algo.datastructure.StackAndQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class ValidParenthness {
    public static void main(String[] args) {
        System.out.println(isValid("[][][][]"));
        System.out.println(isValid("[{{{}}}]"));
        System.out.println(isValid("[{{{}}})"));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();

                if (ch == '}' && top != '{') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
                if (ch == ')' && top != '(') {
                    return false;
                }
            }

        }

        return st.isEmpty();
    }
}
