package com.xworkz.mathtester;

import com.xworkz.mathoperations.MathOperation;
import com.xworkz.mathoperations.MathOperationImpl;

public class MathTester {

	public static void main(String[] args) {
		
		MathOperation mop = new MathOperationImpl();
		
		System.out.println("Addition of 2 nos: " + mop.addition(20, 10));
		System.out.println("Subtraction of 2 nos: " + mop.subtraction(20, 10));
		System.out.println("Multiplication of 2 nos: " + mop.multiplication(20, 10));
		System.out.println("Division of 2 nos: " + mop.division(20, 5));
		System.out.println("Modulus of 2 nos: " + mop.modulus(20, 4));
		
	}

}
