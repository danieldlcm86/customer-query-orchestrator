package com.possumus.customer.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
public class CustomerQueryResourceTest {

	@Test
	void shouldReturn200AndCustomerBasicDataWhenCustomerExists() {
		given()
				.when().get("/customers/12345678")
				.then()
				.statusCode(200)
				.body("$", hasKey("customerNumber"))
				.body("$", hasKey("fullName"))
				.body("$", hasKey("segment"))
				.body("$", hasKey("status"))
				.body("$", not(hasKey("email")))
				.body("$", not(hasKey("phone")));
	}

	@Test
	void shouldReturn400AndErrorPayloadWhenCustomerNumberFormatIsInvalid() {
		given()
				.when().get("/customers/123")
				.then()
				.statusCode(400)
				.body("$", hasKey("code"))
				.body("$", hasKey("message"))
				.body("$", hasKey("timestamp"))
				.body("code", notNullValue())
				.body("message", notNullValue())
				.body("timestamp", notNullValue());
	}

	@Test
	void shouldReturn404AndErrorPayloadWhenCustomerDoesNotExist() {
		given()
				.when().get("/customers/99999999")
				.then()
				.statusCode(404)
				.body("$", hasKey("code"))
				.body("$", hasKey("message"))
				.body("$", hasKey("timestamp"))
				.body("code", notNullValue())
				.body("message", notNullValue())
				.body("timestamp", notNullValue());
	}

}
