package com.possumus.customer.repository;

import com.possumus.customer.model.Customer;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class CustomerRepository {

	private final Map<String, Customer> customers = Map.of(
			"12345678", new Customer("12345678", "Laura Garcia", "Premium", "Activo", "laura.garcia@example.com", "+34111111111"),
			"23456789", new Customer("23456789", "Miguel Perez", "Standard", "Inactivo", "miguel.perez@example.com", "+34222222222"),
			"34567890", new Customer("34567890", "Ana Torres", "Basic", "Activo", "ana.torres@example.com", "+34333333333")
	);

	public Optional<Customer> findByCustomerNumber(String customerNumber) {
		return Optional.ofNullable(customers.get(customerNumber));
	}
}
