package com.possumus.customer.mapper;

import com.possumus.customer.dto.CustomerResponse;
import com.possumus.customer.model.Customer;

public class CustomerMapper {

	private CustomerMapper() {
	}

	public static CustomerResponse toResponse(Customer customer) {
		return new CustomerResponse(
			customer.customerNumber(),
			customer.fullName(),
			customer.segment(),
			customer.status()
		);
	}

}
