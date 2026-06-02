package com.possumus.customer.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CustomerQueryResourceTest {

	@Test
	void shouldReturn200AndExpectedFieldsWhenCustomerExists() {
		given()
			.when()
				.get("/customers/12345678")
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
	void shouldReturn400WhenCustomerNumberFormatIsInvalid() {
		given()
			.when()
				.get("/customers/123")
			.then()
				.statusCode(400)
				.body("code", notNullValue())
				.body("message", notNullValue())
				.body("timestamp", notNullValue());
	}

	@Test
	void shouldReturn404WhenCustomerDoesNotExist() {
		given()
			.when()
				.get("/customers/99999999")
			.then()
				.statusCode(404)
				.body("code", notNullValue())
				.body("message", notNullValue())
				.body("timestamp", notNullValue());
	}

}
