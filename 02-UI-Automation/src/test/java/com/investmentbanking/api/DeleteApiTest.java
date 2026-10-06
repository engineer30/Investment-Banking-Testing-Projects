package com.investmentbanking.api;

import java.util.Collections;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteApiTest {

    @Test
    public void deletePost() {

        given()
        .when()
            .delete("https://jsonplaceholder.typicode.com/posts/1")
        .then()
            .statusCode(200)
            .header("Content-Type", containsString("application/json"))
            .body("$", equalTo(Collections.emptyMap()));
    }
}
