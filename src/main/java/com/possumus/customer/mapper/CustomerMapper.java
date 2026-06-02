package com.possumus.customer.mapper;

import com.possumus.customer.dto.CustomerResponse;
import com.possumus.customer.model.Customer;

public class CustomerMapper {

	public CustomerResponse toResponse(Customer customer) {
		if (customer == null) {
			return null;
		}

		return new CustomerResponse(
				customer.customerNumber(),
				customer.fullName(),
				customer.segment(),
				customer.status()
		);
	}

}
