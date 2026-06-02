package com.possumus.customer.exception;

import java.time.Instant;

import org.jboss.logging.Logger;

import com.possumus.customer.dto.ErrorResponse;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class InvalidCustomerNumberExceptionMapper implements ExceptionMapper<InvalidCustomerNumberException> {

	private static final Logger LOG = Logger.getLogger(InvalidCustomerNumberExceptionMapper.class);

	@Override
	public Response toResponse(InvalidCustomerNumberException exception) {
		LOG.warn("Invalid customer number format received");

		ErrorResponse errorResponse = new ErrorResponse(
			"INVALID_CUSTOMER_NUMBER",
			"Customer number must contain exactly 8 numeric digits",
			Instant.now().toString()
		);

		return Response
			.status(Response.Status.BAD_REQUEST)
			.type(MediaType.APPLICATION_JSON)
			.entity(errorResponse)
			.build();
	}
}