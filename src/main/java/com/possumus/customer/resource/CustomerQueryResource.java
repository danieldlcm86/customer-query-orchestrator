package com.possumus.customer.resource;

import org.jboss.logging.Logger;

import com.possumus.customer.dto.CustomerResponse;
import com.possumus.customer.orchestrator.CustomerQueryOrchestrator;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerQueryResource {

	private static final Logger LOG = Logger.getLogger(CustomerQueryResource.class);

	private final CustomerQueryOrchestrator customerQueryOrchestrator;

	public CustomerQueryResource() {
		this(new CustomerQueryOrchestrator());
	}

	public CustomerQueryResource(CustomerQueryOrchestrator customerQueryOrchestrator) {
		this.customerQueryOrchestrator = customerQueryOrchestrator;
	}

	@GET
	@Path("/{customerNumber}")
	public CustomerResponse getCustomerByNumber(@PathParam("customerNumber") String customerNumber) {
		String maskedCustomerNumber = maskCustomerNumber(customerNumber);
		LOG.infof("HTTP request received. GET /customers/%s", maskedCustomerNumber);

		CustomerResponse response = customerQueryOrchestrator.queryCustomer(customerNumber);

		LOG.infof("HTTP request completed. GET /customers/%s", maskedCustomerNumber);
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
