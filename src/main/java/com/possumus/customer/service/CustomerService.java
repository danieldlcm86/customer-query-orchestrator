package com.possumus.customer.service;

import com.possumus.customer.exception.CustomerNotFoundException;
import com.possumus.customer.exception.InvalidCustomerNumberException;
import com.possumus.customer.model.Customer;
import com.possumus.customer.repository.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.regex.Pattern;

@ApplicationScoped
public class CustomerService {

	private static final Pattern CUSTOMER_NUMBER_PATTERN = Pattern.compile("^[0-9]{8}$");

	private final CustomerRepository customerRepository;

	@Inject
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer getCustomerByNumber(String customerNumber) {
		validateCustomerNumber(customerNumber);

		return customerRepository.findByCustomerNumber(customerNumber)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + customerNumber));
	}

	private void validateCustomerNumber(String customerNumber) {
		if (customerNumber == null || customerNumber.isBlank()) {
			throw new InvalidCustomerNumberException("Customer number must not be null or empty");
		}

		if (!CUSTOMER_NUMBER_PATTERN.matcher(customerNumber).matches()) {
			throw new InvalidCustomerNumberException("Customer number must contain exactly 8 numeric digits");
		}
	}

}
