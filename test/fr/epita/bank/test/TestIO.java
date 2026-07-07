package fr.epita.bank.test;

import java.util.Scanner;

public class TestIO {

    static void main(String[] args) {
        System.out.println("Hello World");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        scanner.nextLine();
        System.out.println("Enter your age");
        scanner.nextInt();
    }
}
