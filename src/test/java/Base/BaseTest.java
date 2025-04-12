package Base;

import apiConfig.HeaderConfig;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import utils.JavaUtilities;

import static org.hamcrest.Matchers.lessThan;

public class BaseTest {
    protected static RequestSpecification requestSpec;
    protected static RequestSpecification requestSpecContentType;
    protected static ResponseSpecification creationResponseSpec;
    protected static ResponseSpecification successResponseSpec;
    HeaderConfig headerConfig = new HeaderConfig();

    @BeforeClass
    public void createRequestSpec() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(JavaUtilities.getBaseUrl())
                .addHeaders(headerConfig.defaultHeaders())
                .build();
    }
    @BeforeClass
    public void createRequestSpecContentType() {
        requestSpecContentType = new RequestSpecBuilder()
                .setBaseUri(JavaUtilities.getBaseUrl())
                .addHeaders(headerConfig.defaultHeadersNoCharset())
                .build();
    }
    @BeforeClass
    public static void createResponseSpec() {
        creationResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType("application/json; charset=utf-8")
                .expectResponseTime(lessThan(3000L)) // Response should be under 3s
                .build();
    }
    @BeforeClass
    public static void successResponseSpec() {
        successResponseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectResponseTime(lessThan(3000L)) // Response should be under 3s
                .build();
    }

}
