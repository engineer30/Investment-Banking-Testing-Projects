package com.investmentbanking.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetApiTest {

    @Test
    public void getAllPosts() {

        given()
        .when()
            .get("https://jsonplaceholder.typicode.com/posts")
        .then()
            .statusCode(200)
            .header("Content-Type", containsString("application/json"))
            .body("[0].id", equalTo(1));
    }
}
