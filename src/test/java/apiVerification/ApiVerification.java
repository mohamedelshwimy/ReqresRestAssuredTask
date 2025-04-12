package apiVerification;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ApiVerification {

    public static void verifyStatusCode(Response response, int expectedCode) {
        System.out.println("Expected Status Code: "+ expectedCode);
        System.out.println("Actual Status Code: "+ response.getStatusCode());
        int actualCode = response.getStatusCode();
        Assert.assertEquals(actualCode, expectedCode, "Expected status code: " + expectedCode + " but found: " + actualCode);
    }

    public static void verifyContentType(Response response, String expectedType) {
        String actualType = response.getContentType();
        Assert.assertEquals(actualType, expectedType, "Expected content type: " + expectedType + " but found: " + actualType);
    }

    public static void verifyFieldPresence(Response response, String field) {
        boolean fieldPresent = response.jsonPath().get(field) != null;
        Assert.assertTrue(fieldPresent, "Field '" + field + "' is not present in the response.");
    }

    public static void verifyFieldValue(Response response, String field, String expected) {
        String actualValue = response.jsonPath().getString(field);
        Assert.assertEquals(actualValue, expected, "Expected value for field '" + field + "' is: " + expected + ", but found: " + actualValue);
    }

    public static void verifyResponseTime(Response response, long maxResponseTime) {
        long actualTime = response.getTime();
        Assert.assertTrue(actualTime <= maxResponseTime, "Response time is too high! Expected <= " + maxResponseTime + "ms but found: " + actualTime + "ms");
    }

    public static void verifySuccessResponses(Response response) {
        verifyStatusCode(response, 200);
    }
    public static void verifyCreationResponse(Response response) {
        verifyStatusCode(response, 201);
    }
}
