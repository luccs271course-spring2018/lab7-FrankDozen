package edu.luc.cs271.linkedstack;

import java.util.Scanner;

public class ReverseLines {

	public static void main(String[] args) {
		final Scanner input = new Scanner(System.in);
		printReverse(input);
	}
	private static void printReverse(Scanner input) {
		LinkedStack<String> RevStack = new LinkedStack<String>();
		if (input.hasNextLine()!= false) {
			String line = input.nextLine();
			RevStack.push(line);
			System.out.println(line);
			printReverse(input);
		}
		System.out.println(RevStack.pop());
	}
}

