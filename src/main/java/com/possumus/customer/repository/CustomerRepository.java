package com.possumus.customer.repository;

import java.util.Map;
import java.util.Optional;

import com.possumus.customer.model.Customer;

public class CustomerRepository {

	private static final Map<String, Customer> CUSTOMERS = Map.of(
		"12345678", new Customer("12345678", "Ana Torres", "Premium", "Activo", "ana.torres@example.com", "+34-600-100-100"),
		"87654321", new Customer("87654321", "Luis Ramirez", "Standard", "Inactivo", "luis.ramirez@example.com", "+34-600-200-200"),
		"11223344", new Customer("11223344", "Maria Gomez", "Basic", "Activo", "maria.gomez@example.com", "+34-600-300-300")
	);

	public Optional<Customer> findByCustomerNumber(String customerNumber) {
		return Optional.ofNullable(CUSTOMERS.get(customerNumber));
	}

}
