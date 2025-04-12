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

public class UpdateUserApi extends BaseTest {
    CreateUserApi createUserApi = new CreateUserApi();
    CommonMethods commonMethods = new CommonMethods();
    CreateUserResponse createUserResponse;
    HeaderConfig headerConfig = new HeaderConfig();
    public static String createdUserId;
    String testDataPath = "src/main/resources/testData/";
    String requestBody = "UpdatedUserRequest.json";

    @Test(priority = 1)
    public void updateUserAPI() throws IOException {
        createUserApi.createUserPostAPI();
        createdUserId = createUserApi.createdUserId;
        System.out.println("createdUserId -> " + createdUserId);

        //API Call
        String jsonFilePath = testDataPath + requestBody;
        String jsonBody = JavaUtilities.jsonReader(jsonFilePath);
        JsonPath fileJsonPath = new JsonPath(jsonBody);
        Response response = commonMethods.updateUser(createdUserId,jsonFilePath);


        //Verify using APIVerification class
        ApiVerification.verifySuccessResponses(response);
        ApiVerification.verifyContentType(response,headerConfig.defaultHeaders().get("Content-Type"));
        ApiVerification.verifyFieldPresence(response,"id");
        ApiVerification.verifyFieldValue(response,"job",fileJsonPath.getString("job"));
        ApiVerification.verifyResponseTime(response,5000);

        //Verify with responseSpec
        response.then().spec(successResponseSpec).log().ifValidationFails();
    }



}
