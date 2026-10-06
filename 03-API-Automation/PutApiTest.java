package com.investmentbanking.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PutApiTest {

    @Test
    public void updatePost() {

        String requestBody = """
                {
                    "id": 1,
                    "title": "Updated Investment Banking Test",
                    "body": "Updated API automation testing",
                    "userId": 1
                }
                """;

        given()
            .contentType("application/json")
            .body(requestBody)
        .when()
            .put("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .statusCode(200)
            .header("Content-Type", containsString("application/json"))
            .body("id", equalTo(1))
            .body("title", equalTo("Updated Investment Banking Test"))
            .body("body", equalTo("Updated API automation testing"))
            .body("userId", equalTo(1));
    }
}
