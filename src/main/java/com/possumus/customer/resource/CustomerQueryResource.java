package com.possumus.customer.resource;

import com.possumus.customer.dto.CustomerResponse;
import com.possumus.customer.orchestrator.CustomerQueryOrchestrator;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerQueryResource {

	private static final Logger LOG = Logger.getLogger(CustomerQueryResource.class);

	private final CustomerQueryOrchestrator customerQueryOrchestrator;

	@Inject
	public CustomerQueryResource(CustomerQueryOrchestrator customerQueryOrchestrator) {
		this.customerQueryOrchestrator = customerQueryOrchestrator;
	}

	@GET
	@Path("/{customerNumber}")
	public CustomerResponse getCustomerByNumber(@PathParam("customerNumber") String customerNumber) {
		String safeCustomerNumber = maskCustomerNumber(customerNumber);
		LOG.infov("Received customer query request for customerNumber={0}", safeCustomerNumber);

		CustomerResponse response = customerQueryOrchestrator.queryCustomer(customerNumber);

		LOG.infov("Returning successful customer query response for customerNumber={0}", safeCustomerNumber);
		return response;
	}

	private String maskCustomerNumber(String customerNumber) {
		if (customerNumber == null || customerNumber.length() < 2) {
			return "**";
		}

		return "******" + customerNumber.substring(customerNumber.length() - 2);
	}

}
