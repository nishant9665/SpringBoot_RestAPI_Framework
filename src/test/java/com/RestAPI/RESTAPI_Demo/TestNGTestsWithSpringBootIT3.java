package com.RestAPI.RESTAPI_Demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.*;

@SpringBootTest(classes = TestNGWithSpringApplication.class)
public class TestNGTestsWithSpringBootIT3 extends AbstractTestNGSpringContextTests {

  //  static ExtentTest test;
    static ExtentReports extent;
    @BeforeClass
    public static void startTest()
    {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }
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
        extent.createTest("simpleTest")
                .log(Status.PASS, "This is a logging event for simpleTest, and it passed!");
        Assert.assertEquals(2 * 2, 4, "2x2 should be 4");

    }

    @Test(priority = 2, description = "This is testcase1")
    public void simpleTest2() {
        extent.createTest("simpleTest2")
                .log(Status.INFO, "This is a logging event for simpleTest2, and it passed!");
        Assert.assertEquals("ABC", "ABC", "ABC is match only");


    }

    @Test
    public void java() {

        extent.createTest("java")
                .log(Status.INFO, "This is a logging event for java, and it passed!");
        Assert.assertEquals("ABC", "ABC", "ABC is match only");

        System.out.println("JAVA language");
    }
    @Test
    public void Smoke_Test() {

        extent.createTest("Smoke_Test")
                .log(Status.FAIL, "This is a logging event for Smoke_Test, and it passed!");
        Assert.assertEquals("ABC", "ABXC", "ABC is match only");
        

        System.out.println("Smoke_Test -QA");
    }
    @Test
    public void Sanity_Test() {

       // extent.createTest("Sanity_Test")
        //        .log(Status.FAIL, "This is a logging event for Sanity_Test, and it passed!");
        Assert.assertEquals("ABC", "ABXC", "ABC is match only");

        System.out.println("Smoke_Test -QA");
    }
    @Test(groups= {"software company"})
    public void wipro()
    {
        extent.createTest("wipro")
                .log(Status.INFO, "This is a logging event for wipro, and it passed!");
        Assert.assertEquals("ABC", "ABC", "ABC is match only");
        System.out.println("Wipro");

    }
    @AfterMethod
    public void tearDown(){
        System.out.println("this teardown");
    }

    @AfterClass
    public static void endTest()
    {
        extent.flush();
    }
}
