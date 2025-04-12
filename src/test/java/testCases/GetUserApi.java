package testCases;

import Base.BaseTest;
import Responses.CreateUserResponse;
import apiConfig.HeaderConfig;
import apiVerification.ApiVerification;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetUserApi extends BaseTest {
    CreateUserApi createUserApi = new CreateUserApi();
    CommonMethods commonMethods = new CommonMethods();
    CreateUserResponse createUserResponse;
    HeaderConfig headerConfig = new HeaderConfig();
    public static String createdUserId;

    @Test(priority = 1)
    public void getUserAPI() throws IOException {
        createUserApi.createUserPostAPI();
        createdUserId = createUserApi.createdUserId;
        System.out.println("createdUserId -> " + createdUserId);

        //API Call
        Response response = commonMethods.getUser(createdUserId);

        //Verify with responseSpec
        response.then().spec(successResponseSpec).log().ifValidationFails();

        //Verify using APIVerification class
        ApiVerification.verifySuccessResponses(response);
        ApiVerification.verifyContentType(response,headerConfig.defaultHeaders().get("Content-Type"));
        ApiVerification.verifyFieldPresence(response,"id");
        ApiVerification.verifyFieldValue(response,"name",createUserResponse.getName());
        ApiVerification.verifyResponseTime(response,5000);

    }

    @Test(priority = 2)
    public void testGetUserWithInvalidUserId() throws IOException {
        Response response = commonMethods.getUser("99999");
        response.then().log().all();
        //Verify using APIVerification
        ApiVerification.verifyStatusCode(response, 404);
    }
}
