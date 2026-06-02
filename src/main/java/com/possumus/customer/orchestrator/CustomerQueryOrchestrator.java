package com.possumus.customer.orchestrator;

import org.jboss.logging.Logger;

import com.possumus.customer.dto.CustomerResponse;
import com.possumus.customer.mapper.CustomerMapper;
import com.possumus.customer.model.Customer;
import com.possumus.customer.service.CustomerService;

public class CustomerQueryOrchestrator {

	private static final Logger LOG = Logger.getLogger(CustomerQueryOrchestrator.class);

	private final CustomerService customerService;

	public CustomerQueryOrchestrator() {
		this(new CustomerService());
	}

	public CustomerQueryOrchestrator(CustomerService customerService) {
		this.customerService = customerService;
	}

	public CustomerResponse queryCustomer(String customerNumber) {
		String maskedCustomerNumber = maskCustomerNumber(customerNumber);
		LOG.infof("Customer query started. customerNumber=%s", maskedCustomerNumber);

		Customer customer = customerService.getCustomerByNumber(customerNumber);
		CustomerResponse response = CustomerMapper.toResponse(customer);

		LOG.infof("Customer query completed. customerNumber=%s", maskedCustomerNumber);
		return response;
	}

	private String maskCustomerNumber(String customerNumber) {
		if (customerNumber == null || customerNumber.isBlank()) {
			return "[empty]";
		}

		if (customerNumber.length() <= 2) {
			return "**";
		}

		return "******" + customerNumber.substring(customerNumber.length() - 2);
	}

}
