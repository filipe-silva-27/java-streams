package com.amigoscode.examples;

import java.util.function.Predicate;

public class _Predicate {

	public static void main(String[] args) {

		//normal
		System.out.println(isPhoneNumberValid("07000000000"));
		System.out.println(isPhoneNumberValid("0403100"));

		//Predicate functional Programming
		System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
		System.out.println(isPhoneNumberValidPredicate.test("0403100"));

		//chain of predicates
		isPhoneNumberValidPredicate.and(containsNumber3).test("07000000000");
		isPhoneNumberValidPredicate.and(containsNumber3).test("0403100");

		isPhoneNumberValidPredicate.or(containsNumber3).test("0403100");

	}


	static boolean isPhoneNumberValid(String phoneNum) {
		return phoneNum.startsWith("07") && phoneNum.length() == 11;
	}

	static Predicate<String> isPhoneNumberValidPredicate = phoneNum ->
			phoneNum.startsWith("07") && phoneNum.length() == 11;


	static Predicate<String> containsNumber3 = phoneNum ->
			phoneNum.contains("3");

}
