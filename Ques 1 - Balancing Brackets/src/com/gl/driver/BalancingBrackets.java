package com.gl.driver;

import java.util.Stack;

public class BalancingBrackets {

	private static final Stack<Character> stack = new Stack<Character>();

	//Function to check brackets String is Balanced 
	public static boolean checkBracketBalanced(String expression) {

		for (int index = 0; index < expression.length(); index++) {
			char character = expression.charAt(index);

			// If Char are Starting Brackets Pushing to stack
			if (character == '(' || character == '{' || character == '[') {
				stack.push(character);
				continue;
			}

			if (stack.empty()) {
				return false;
			}

			char checkBracket;

			switch (character) {
			case '}':
				checkBracket = stack.pop();
				if (checkBracket == '(' || checkBracket == '[') {
					return false;
				}
				break;
			case ')':
				checkBracket = stack.pop();
				if (checkBracket == '{' || checkBracket == '[') {
					return false;
				}
				break;
			case ']':
				checkBracket = stack.pop();
				if (checkBracket == '{' || checkBracket == '(') {
					return false;
				}
				break;
			}

		}
		return (stack.isEmpty());
	}

	//Driver Code
	public static void main(String[] args) {

		// Balanced Bracket
		String bracketsString = "[{()}]";

		// Unbalanced Brackets
		// String brackets = "([[{}]]))";

		if (checkBracketBalanced(bracketsString.trim())) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}
}
