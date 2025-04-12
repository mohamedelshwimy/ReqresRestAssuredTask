package testCases;

import Base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JavaUtilities;

import java.io.IOException;

public class CommonMethods extends BaseTest {
    public Response createUser(String jsonBody) throws IOException {
        System.out.println("POST");
        return RestAssured.given()
                .spec(requestSpec)
                .body(jsonBody)
                .log().all()
                .when()
                .post(JavaUtilities.getCreateUserEndPoint());
    }

    public Response getUser(String userId) throws IOException {
        System.out.println("GET");
        return RestAssured.given()
                .spec(requestSpecContentType)
                .pathParam("id", userId)
                .log().all()
                .when()
                .get(JavaUtilities.getGetUserEndPoint() + "{id}");
    }
    public Response updateUser(String userId,String jsonBody) throws IOException {
        System.out.println("PUT");
        return RestAssured.given()
                .spec(requestSpecContentType)
                .body(jsonBody)
                .log().all()
                .when()
                .put(JavaUtilities.getUpdateUserEndPoint() + userId);
    }
}

