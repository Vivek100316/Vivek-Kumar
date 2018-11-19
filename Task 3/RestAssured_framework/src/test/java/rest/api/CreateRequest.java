package rest.api;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.Random;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRequest {

	public static RequestSpecification createProductRequest()
	{
		RequestSpecification request = RestAssured.given();
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "New Product"); // Cast
		 requestParams.put("type", "Hard Good");
		 requestParams.put("upc", "12345676");
		 requestParams.put("price", 99.99);		 
		 requestParams.put("description",  "This is a placeholder request for creating a new product.");
		 requestParams.put("model",  "NP12345");
		 
		 System.out.println(requestParams.toString());

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toString());
		
		return request;
	}
	
	public static RequestSpecification createStoreRequest()
	{
		RequestSpecification request = RestAssured.given();
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "New Store"); // Cast
		 requestParams.put("type", "BigBox");
		 requestParams.put("address", "123 Fake St");
		 requestParams.put("address2", "");
		 requestParams.put("city", "Springfield");		 
		 requestParams.put("state",  "MN");
		 requestParams.put("zip",  "55123");
		 requestParams.put("lat",  44.969658);
		 requestParams.put("lng",  -93.449539);
		 requestParams.put("hours",  "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");
		 
		 System.out.println(requestParams.toString());

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		request.body(requestParams.toString());
		
		return request;
	}
	
	public static RequestSpecification createServiceRequest()
	{
		RequestSpecification request = RestAssured.given();
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "New Service"); // Cast
		 
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add the Json to the body of the request
		request.body(requestParams.toString());
		
		return request;
	}
	
	public static RequestSpecification createCategoriesRequest()
	{
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 12) 
        
        { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        System.out.println("Random id : " + saltStr);
        
//		Random random = new Random();
//		String id = random.ints(11).toString();
//		System.out.println("Random id : " + id);
		RequestSpecification request = RestAssured.given();
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("id", saltStr);
		 requestParams.put("name", "New Category");
		 
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");
		// Add the Json to the body of the request
		request.body(requestParams.toString());
		
		return request;
	}
}
