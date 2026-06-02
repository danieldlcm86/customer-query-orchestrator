package com.possumus.customer.exception;

import java.time.Instant;

import org.jboss.logging.Logger;

import com.possumus.customer.dto.ErrorResponse;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomerNotFoundExceptionMapper implements ExceptionMapper<CustomerNotFoundException> {

	private static final Logger LOG = Logger.getLogger(CustomerNotFoundExceptionMapper.class);

	@Override
	public Response toResponse(CustomerNotFoundException exception) {
		LOG.info("Customer not found for requested customer number");

		ErrorResponse errorResponse = new ErrorResponse(
			"CUSTOMER_NOT_FOUND",
			"Customer not found",
			Instant.now().toString()
		);

		return Response
			.status(Response.Status.NOT_FOUND)
			.type(MediaType.APPLICATION_JSON)
			.entity(errorResponse)
			.build();
	}
}