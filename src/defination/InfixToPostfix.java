package defination;

import adt.InfixToPostfixADT;

public class InfixToPostfix implements InfixToPostfixADT {
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
