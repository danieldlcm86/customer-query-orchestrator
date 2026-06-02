package com.possumus.customer.dto;

public record ErrorResponse(
        String code,
        String message,
        String timestamp
) {
}
