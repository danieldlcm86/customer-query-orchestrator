package com.possumus.customer.exception;

import com.possumus.customer.dto.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.Instant;

@Provider
public class CustomerNotFoundExceptionMapper implements ExceptionMapper<CustomerNotFoundException> {

    @Override
    public Response toResponse(CustomerNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                "CUSTOMER_NOT_FOUND",
                exception.getMessage(),
                Instant.now().toString()
        );

        return Response.status(Response.Status.NOT_FOUND)
                .entity(errorResponse)
                .build();
    }
}
