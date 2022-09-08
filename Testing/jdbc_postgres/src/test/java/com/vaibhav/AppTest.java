package com.vaibhav;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void checkGetApiUsingJsonPlaceHolder() { // create base url
        try {
            // create base URL for Endpoint
            RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";

            // create request object
            RequestSpecification httpGetRequest = RestAssured.given();

            // create responce object
            Response response = httpGetRequest.request(Method.GET, "/1");

            // responce validation

            int StatusCode = response.getStatusCode();
            Assert.assertEquals(StatusCode, 200);

            // status Line Verification

            String StatusLine = response.getStatusLine();
            Assert.assertEquals("HTTP/1.1 200 OK", StatusLine);

            System.out.println("Get Request Successfully Done");

        } catch (Exception e) {
            System.out.println("This Message From Method GetRequest Catch Body" + e.getMessage());
        }
    }

    @Test
    public void postApiRequest() {
        try {
            RestAssured.baseURI = "http://localhost:8081/users";
            RequestSpecification httpRequest = RestAssured.given();

            // Request Payload sending along with post request
            Map<String, String> jsonObjectValues = new HashMap();

            jsonObjectValues.put("fullName", "vaibhav deshmukh");
            jsonObjectValues.put("email", "vaibhavdeshmukh0703@gmail.com");
            jsonObjectValues.put("password", "vaibhav@123");

            JSONObject jsonObject = new JSONObject(jsonObjectValues);

            // Create Header For Request Content-type = application/json.
            httpRequest.header("Content-Type", "application/json; charset=UTF-8");

            httpRequest.body(jsonObject);

            Response response = httpRequest.request(Method.POST, "/signup");

            String responseData = response.asString();
            System.out.println(responseData);

            // int responseCode = response.getStatusCode();
            // assertEquals(201, responseCode);

            JsonPath result = response.jsonPath();
            String message = result.get("message");
            Assert.assertEquals(message, "Vendor is All ready Registered");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("This Msg from  method catch body" + e.getMessage());
            e.printStackTrace();
        }
    }
}
