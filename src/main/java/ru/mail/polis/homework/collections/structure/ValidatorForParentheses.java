package ru.mail.polis.homework.collections.structure;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Задание оценивается в 2 тугрика.
 * Одна из самых популярных задач.
 * Реализовать метод, который проверяет правильность написания скобок в строке.
 * В строке помимо скобок могут содержаться и другие символы.
 * Скобки могут быть: [],{},<>,()
 * Примеры:
 * "(-b + (x)^2)/(2+4)" - true
 * "Понедельники меня угнетают ((" - false
 * <p>
 * Отрабатывать метод должен за О(n)
 */
public class ValidatorForParentheses {
    private static final Character[] PARENTHESES = {'{', '}', '[', ']', '<', '>', '(', ')'};

    public static boolean validate(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        final List<Character> listOfParentheses = Arrays.asList(PARENTHESES);
        Stack<Character> stack = new Stack<>();
        boolean bracketExists = false;
        for (int i = 0; i < value.length(); i++) {
            if (!listOfParentheses.contains(value.charAt(i))) {
                continue;
            }
            bracketExists = true;
            if (i != 0 && !stack.isEmpty() && isClosedBracket(value.charAt(i), stack.peek())) {
                stack.pop();
                continue;
            }
            stack.push(value.charAt(i));
        }
        return bracketExists && stack.empty();
    }

    private static boolean isClosedBracket(char current, char opening) {
        if (current == '}' && opening == '{') {
            return true;
        }
        if (current == ')' && opening == '(') {
            return true;
        }
        if (current == '>' && opening == '<') {
            return true;
        }
        return current == ']' && opening == '[';
    }
}
