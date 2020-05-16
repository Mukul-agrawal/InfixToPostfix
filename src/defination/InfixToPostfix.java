package defination;

import adt.InfixToPostfixADT;

import java.util.ArrayDeque;
import java.util.Deque;

public class InfixToPostfix implements InfixToPostfixADT {
    private final Deque<Character> operatorStack = new ArrayDeque<>();
    private final String OPERATORS = "+-*/^";
    private final int[] PRECEDENCE = {1, 1, 2, 2, 3};
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
        return 0;
    }

    @Override
    public String getPostfix() {
        return null;
    }
}
