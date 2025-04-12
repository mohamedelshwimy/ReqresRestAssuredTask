package testCases;

import Base.BaseTest;
import Responses.CreateUserResponse;
import apiConfig.HeaderConfig;
import apiVerification.ApiVerification;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.JavaUtilities;

import java.io.IOException;

public class CreateUserApi extends BaseTest {
    CommonMethods commonMethods = new CommonMethods();
    HeaderConfig headerConfig = new HeaderConfig();
    CreateUserResponse createUserResponse = new CreateUserResponse();
    String testDataPath = "src/main/resources/testData/";
    String requestBody = "ValidUserRequest.json";
    public String createdUserId;


    @Test(priority = 1)
    public void createUserPostAPI() throws IOException {
        String jsonFilePath = testDataPath + requestBody;
        String jsonBody = JavaUtilities.jsonReader(jsonFilePath);
        JsonPath fileJsonPath = new JsonPath(jsonBody);

        //Send Create User Request
        Response response = commonMethods.createUser(jsonBody);
        JsonPath jsonPath = new JsonPath(response.getBody().asString());
        createdUserId = jsonPath.getString("id");
        System.out.println("createdUserId -> " + createdUserId);

        //Set Created User Details
        createUserResponse.setName(jsonPath.getString("name"));
        createUserResponse.setJob(jsonPath.getString("job"));
        createUserResponse.setId(jsonPath.getString("id"));
        createUserResponse.setCreatedAt(jsonPath.getString("createdAt"));

        //Verify using APIVerification class
        ApiVerification.verifyCreationResponse(response);
        ApiVerification.verifyContentType(response,headerConfig.defaultHeaders().get("Content-Type"));
        ApiVerification.verifyFieldPresence(response,"id");
        ApiVerification.verifyFieldValue(response,"name",fileJsonPath.getString("name"));
        ApiVerification.verifyResponseTime(response,5000);

        //Verify with responseSpec
        response.then().spec(creationResponseSpec).log().ifValidationFails();

        //response.then().log().All(); //Can be used to check everything in the response
    }

}
