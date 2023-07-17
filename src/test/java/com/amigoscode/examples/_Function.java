package com.amigoscode.examples;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

	public static void main(String[] args) {
		int increment = incrementByOne(1);
		System.out.println(increment);

		int increment2 = incrementByOneFunction.apply(1);
		System.out.println(increment2);

		int multiply = multiplyBy10Function.apply(1);
		System.out.println(multiply);

		Function<Integer, Integer> incrementAndMultiplyFunction = incrementByOneFunction.andThen(multiplyBy10Function);

		Integer incAndMultiply = incrementAndMultiplyFunction.apply(1);
		System.out.println(incAndMultiply);

		//BiFunction
		System.out.println(incrementByOneAndMultiplyBy(4,100));
		System.out.println(incrementByOneAndMultiplyByFunction.apply(4,100));
	}

	static Function<Integer, Integer> incrementByOneFunction =
			number -> ++number;

	static Function<Integer,Integer> multiplyBy10Function =
			number -> number * 10;
	static int incrementByOne(int i) {
		return ++i;
	}

	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyByFunction =
			(number1, numToMultiplyBy) -> (number1 + 1) * numToMultiplyBy;

	static int incrementByOneAndMultiplyBy(int number, int numToMultiplyBy){
		return (number + 1) * numToMultiplyBy;
	}
}
