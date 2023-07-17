package com.amigoscode.examples;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

	public static void main(String[] args) {
		Customer maria = new Customer("Maria", "99999");

		//normal Java
		greetCustomer(maria);

		//Consumer functional interface
		greetCustomerConsumer.accept(maria);

		//BiConsumer specifying what to show with another argument
		greetCustomerBiConsumer.accept(maria, false);
	}

	static BiConsumer<Customer, Boolean> greetCustomerBiConsumer =
			(customer, showPhoneNum) -> System.out.println("Hello " + customer.name
					+ ", thanks for registering phone number "
					+ (showPhoneNum ? customer.phoneNum : "*********"));

	static Consumer<Customer> greetCustomerConsumer =
			customer -> System.out.println("Hello " + customer.name
			+ ", thanks for registering phone number "
			+ customer.phoneNum);



	static void greetCustomer(Customer customer){
		System.out.println("Hello " + customer.name
				+ ", thanks for registering phone number "
				+ customer.phoneNum);
	}


	static class Customer{

		private String name;
		private String phoneNum;


		Customer(final String name, final String phoneNum) {
			this.name = name;
			this.phoneNum = phoneNum;
		}
	}

}
