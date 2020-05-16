package defination;

import adt.InfixToPostfixADT;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

public class InfixToPostfix implements InfixToPostfixADT {
    private final Deque<Character> operatorStack = new ArrayDeque<>();
    private final String OPERATORS = "+-*/^";
    private final int[] PRECEDENCE = {1, 1, 2, 2, 3};
    private StringJoiner postfix = new StringJoiner(" ");

    public String convert(String infix) {
        convertToPostfix(infix);
        return getPostfix();
    }

    @Override
    public void convertToPostfix(String infix) {

    }

    @Override
    public void processOperator(char op) {

    }

    @Override
    public boolean isOperator(char ch) {
        return false;
    }

    @Override
    public int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    @Override
    public String getPostfix() {
        return postfix.toString();
    }
}
