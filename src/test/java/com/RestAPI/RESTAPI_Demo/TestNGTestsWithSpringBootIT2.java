package com.RestAPI.RESTAPI_Demo;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest(classes = TestNGWithSpringApplication.class)
public class TestNGTestsWithSpringBootIT2 extends AbstractTestNGSpringContextTests {
    @Test
    public void GetBooksDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://localhost:8081";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.request(Method.GET, "/home");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @BeforeMethod
    public void setup(){
        System.out.println("this setup");
    }
    @Test(priority = 1, enabled = false)
    public void simpleTest() {
        Assert.assertEquals(2 * 2, 4, "2x2 should be 4");
    }

    @Test(priority = 2, description = "This is testcase1")
    public void simpleTest2() {
        Assert.assertEquals("ABC", "ABC", "ABC is match only");
    }

    @Test
    public void java() {
        System.out.println("JAVA language");
    }
    @Test(groups= {"software company"})
    public void wipro()
    {
        System.out.println("Wipro");

    }
    @AfterMethod
    public void tearDown(){
        System.out.println("this teardown");
    }
}