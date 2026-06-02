package com.possumus.customer.exception;

import com.possumus.customer.dto.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.Instant;

@Provider
public class InvalidCustomerNumberExceptionMapper implements ExceptionMapper<InvalidCustomerNumberException> {

    @Override
    public Response toResponse(InvalidCustomerNumberException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                "INVALID_CUSTOMER_NUMBER",
                exception.getMessage(),
                Instant.now().toString()
        );

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(errorResponse)
                .build();
    }
}
