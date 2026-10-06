package com.investmentbanking.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostApiTest {

    @Test
    public void createPost() {

        String requestBody = """
                {
                    "title": "Investment Banking Test",
                    "body": "API automation testing",
                    "userId": 1
                }
                """;

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .post("https://jsonplaceholder.typicode.com/posts")
        .then()
            .statusCode(201)
            .header("Content-Type", containsString("application/json"))
            .body("title", equalTo("Investment Banking Test"))
            .body("body", equalTo("API automation testing"))
            .body("userId", equalTo(1));
    }
}
