package rest.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIPlayground {
	
	// I have hard-coded the BaseUrin just to make it simple. Else we can pass it in
    //	Configuration properties file or in testng.xml or in data providers
	
	// Similarly we can have many ways to run the priorties the tests. I just choose the simple when by using TestNG priority annotation.
	@Test (priority=1)
	public  static void createProduct()
	{
		
		RequestSpecification request = CreateRequest.createProductRequest();
		// Post the request and check the response
		
		Response response = request.post("http://localhost:3030/products");
		
	    String strResponse= response.asString();
	    System.out.println("create product response = "+ strResponse);
		int  code = response.getStatusCode();
		System.out.println("create product status code = "+ code);
		Assert.assertEquals( code,201);
		
		Assert.assertTrue(strResponse.contains("id"));
		Assert.assertTrue(strResponse.contains("createdAt") && strResponse.contains("updatedAt")
				  && strResponse.contains("model") && strResponse.contains("price"));
		
		
	}
	
	@Test(priority=2)
	public static void createStore()
	{
		RequestSpecification request = CreateRequest.createStoreRequest();
		// Post the request and check the response
		Response response = request.post("http://localhost:3030/stores");
		 	 		 
	    String strResponse= response.asString();
	    System.out.println("create product response = "+ strResponse);
		int  code = response.getStatusCode();
		System.out.println("create product status code = "+ code);
		Assert.assertEquals( code,201);
		
	}
	
	@Test(priority=3)
	public static void createService()
	{
		RequestSpecification request = CreateRequest.createServiceRequest();
		Response response = request.post("http://localhost:3030/services");		 	 		 
	    String strResponse= response.asString();
	    System.out.println("create product response = "+ strResponse);
		int  code = response.getStatusCode();
		System.out.println("create product status code = "+ code);
		Assert.assertEquals(code,201);
		
	}
	
	@Test(priority=4)
	public static void createCategory()
	{
		RequestSpecification request = CreateRequest.createCategoriesRequest();
		Response response = request.post("http://localhost:3030/categories");		 	 		 
	    String strResponse= response.asString();
	    System.out.println("create product response = "+ strResponse);
		int  code = response.getStatusCode();
		System.out.println("create product status code = "+ code);
		Assert.assertEquals(code,201);
		
	}
	
	@Test(priority=5)
	public static void getStoresSellApple()
	{
		Response response = RestAssured.get("http://localhost:3030/stores?service.name=Apple Shop");
		String strResponse= response.asString();
	    System.out.println("create product response = "+ strResponse);
		int  code = response.getStatusCode();
		System.out.println("create product status code = "+ code);
		Assert.assertEquals(code,200);
		
		long respTime = response.getTime();
		
		//validating the performance of get response time  : restricting it to 15 seconds
		long maxrespTime = 15000 ;
		Assert.assertTrue(respTime<maxrespTime);
	}
	
	
	@Test(priority=6)
	public static void getStoresinMN()
	{
		Response response = RestAssured.get("http://localhost:3030/stores?state=MN");
		String strResponse= response.asString();
	    System.out.println("create product response = "+ strResponse);
		int  code = response.getStatusCode();
		System.out.println("create product status code = "+ code);
		Assert.assertEquals(code,200);
		
		long respTime = response.getTime();
		
		//validating the performance of get response time  : restricting it to 15 seconds
		long maxrespTime = 15000 ;
		Assert.assertTrue(respTime<maxrespTime);
	}
	
	
	
	@Test(priority=7)
	public static void getStoresInTenMiles()
	{
		Response response = RestAssured.get("http://localhost:3030/stores?near=90210&service.name=Windows%20Store");
		String strResponse= response.asString();
	    System.out.println("create product response = "+ strResponse);
		int  code = response.getStatusCode();
		System.out.println("create product status code = "+ code);
		Assert.assertEquals(code,200);
		
		long respTime = response.getTime();
		
		//validating the performance of get response time  : restricting it to 15 seconds
		long maxrespTime = 15000 ;
		Assert.assertTrue(respTime<maxrespTime);
	}
	
	@Test(priority=8)
	public static void getProductAndDescription()
	{
		Response response = RestAssured.get("http://localhost:3030/products?$select[]=name&$select[]=description");
		String strResponse= response.asString();
	    System.out.println("create product response = "+ strResponse);
		int  code = response.getStatusCode();
		System.out.println("create product status code = "+ code);
		Assert.assertEquals(code,200);
		
		long respTime = response.getTime();
		
		//validating the performance of get response time  : restricting it to 15 seconds
		long maxrespTime = 15000 ;
		Assert.assertTrue(respTime<maxrespTime);
	}
	
	@Test(priority=9)
	public static void getTVfreeShippingPrice()
	{
		Response response = RestAssured.get("http://localhost:3030/products?category.name=TVs&price[$gt]=500&price[$lt]=800&shipping[$eq]=0");
		String strResponse= response.asString();
	    System.out.println("create product response = "+ strResponse);
		int  code = response.getStatusCode();
		System.out.println("create product status code = "+ code);
		Assert.assertEquals(code,200);
		
		long respTime = response.getTime();
		
		//validating the performance of get response time  : restricting it to 15 seconds
		long maxrespTime = 15000 ;
		Assert.assertTrue(respTime<maxrespTime);
	}

}
