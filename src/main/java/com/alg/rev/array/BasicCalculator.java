package com.alg.rev.array;

import java.util.Stack;

public class BasicCalculator {

	public static int calcaulate(String str) {

		Stack<Integer> operand = new Stack<Integer>();
		Stack<Character> operator = new Stack<Character>();
		int inVaildParanthisCount = 0;
		for (Character oneChar : str.toCharArray()) {

			if (oneChar.equals(' '))
				continue;

			if (Character.isDigit(oneChar)) {
				if (!operator.isEmpty() && (operator.peek().equals('+') || operator.peek().equals('-'))) {
					addOperand(operand, operator, oneChar);

				} else {

					operand.push(Integer.valueOf(oneChar.toString()));
				}

			} else if (oneChar.equals('+') || oneChar.equals('-') || oneChar.equals('(')) {
				if (oneChar.equals('(')) {
					operator.push(oneChar);
					inVaildParanthisCount++;
				} else {
					operator.push(oneChar);
				}
			} else if (oneChar.equals(')')) {
				if (inVaildParanthisCount > 0) {
					if (operator.peek().equals('(')) {
						operator.pop();
						inVaildParanthisCount--;
					} else {

						while (!operator.isEmpty() && !operator.peek().equals('(')) {
							addOperand(operand, operator);
						}
						if (operator.peek().equals('(')) {
							operator.pop();
							inVaildParanthisCount--;
						}
					}
				}else {
					throw new IllegalArgumentException();
				}

			}

		}

		if (!operator.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return operand.pop().intValue();

	}

	private static void addOperand(Stack<Integer> operand, Stack<Character> operator) {
		Character oneCharTemp = operator.pop();
		if (oneCharTemp.equals('+') || oneCharTemp.equals('-')) {
			if (oneCharTemp.equals('+')) {

				Integer r = operand.pop() + operand.pop();

				operand.push(r);

			} else {
				Integer r = operand.pop() - operand.pop();
				operand.push(r);

			}

		}
	}

	private static void addOperand(Stack<Integer> operand, Stack<Character> operator, Character oneChar) {
		Character tempOper = operator.pop();
		if (tempOper.equals('+')) {

			Integer r = operand.pop() + Integer.valueOf(oneChar.toString());

			operand.push(r);

		} else {
			Integer r = operand.pop() - Integer.valueOf(oneChar.toString());
			operand.push(r);

		}
	}

	public static void main(String[] args) {
		System.out.println(calcaulate("((1+1)+(1+1)+(1+1)))"));
	}

}
