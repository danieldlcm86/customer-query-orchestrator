package com.possumus.customer.model;

public record Customer(
	String customerNumber,
	String fullName,
	String segment,
	String status,
	String email,
	String phone
) {

}
