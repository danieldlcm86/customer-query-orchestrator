package com.possumus.customer.dto;

public record CustomerResponse(
	String customerNumber,
	String fullName,
	String segment,
	String status
) {

}
