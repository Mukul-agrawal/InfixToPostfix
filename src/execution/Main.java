package execution;

import defination.InfixToPostfix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        System.out.println("Enter the infix expression :");
        String infix = scanner.nextLine();

    }
}
