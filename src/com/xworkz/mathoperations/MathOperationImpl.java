package com.xworkz.mathoperations;

public class MathOperationImpl implements MathOperation {

	@Override
	public int addition(int a, int b) {
		
		return a + b;
	}

	@Override
	public int subtraction(int a, int b) {
		
		return a - b;
	}

	@Override
	public int multiplication(int a, int b) {
		
		return a * b;
	}

	@Override
	public int division(int a, int b) {
		
		if (b != 0)
			return a / b;
		else
			throw new RuntimeException("divisor should be a non-zero number");
	}

	@Override
	public int modulus(int a, int b) {
		if (b != 0)
			return a % b;
		else
			throw new RuntimeException("divisor should be a non-zero number");
	}

}
