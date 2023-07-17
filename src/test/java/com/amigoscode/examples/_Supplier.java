package com.amigoscode.examples;

import java.util.function.Supplier;

public class _Supplier {

	public static void main(String[] args) {

		//normal
		System.out.println(getDBConnectionUrl());

		//Supplier
		System.out.println(getDBConnectionSupplier.get());
	}

	static String getDBConnectionUrl () {
		return "jdbc://localhost:5432/users";
	}

	static Supplier<String> getDBConnectionSupplier = () ->
			"jdbc://localhost:5432/users";
}
