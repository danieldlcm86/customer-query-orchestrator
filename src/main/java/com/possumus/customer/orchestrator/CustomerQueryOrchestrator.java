package com.possumus.customer.orchestrator;

import com.possumus.customer.dto.CustomerResponse;
import com.possumus.customer.mapper.CustomerMapper;
import com.possumus.customer.model.Customer;
import com.possumus.customer.service.CustomerService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class CustomerQueryOrchestrator {

	private static final Logger LOG = Logger.getLogger(CustomerQueryOrchestrator.class);

	private final CustomerService customerService;
	private final CustomerMapper customerMapper;

	@Inject
	public CustomerQueryOrchestrator(CustomerService customerService) {
		this.customerService = customerService;
		this.customerMapper = new CustomerMapper();
	}

	public CustomerResponse queryCustomer(String customerNumber) {
		String safeCustomerNumber = maskCustomerNumber(customerNumber);
		LOG.infov("Starting customer query for customerNumber={0}", safeCustomerNumber);

		Customer customer = customerService.getCustomerByNumber(customerNumber);
		CustomerResponse response = customerMapper.toResponse(customer);

		LOG.infov("Customer query completed for customerNumber={0}", safeCustomerNumber);
		return response;
	}

	private String maskCustomerNumber(String customerNumber) {
		if (customerNumber == null || customerNumber.length() < 2) {
			return "**";
		}

		return "******" + customerNumber.substring(customerNumber.length() - 2);
	}

}
