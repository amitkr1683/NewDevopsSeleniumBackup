package sauseLAB_IntegrationExamples;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RESTAPI_GET_Test {

	@Test
	public void test_01_listUser() {

		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println("Status Code: " + resp.getStatusCode());
		System.out.println("Response Time: " + resp.getTime());

	}
}