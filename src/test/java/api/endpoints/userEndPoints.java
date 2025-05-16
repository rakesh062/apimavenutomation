package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class userEndPoints {
	
	static ResourceBundle getURL() {
		
		ResourceBundle routes= ResourceBundle.getBundle("routes");
		
		return routes;
	}
	
	public static Response createUser(User payload){
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
		.when()
			.post(Routes.post_url);
		
		return response;
		
		
	}
	
	public static Response readUser(String userName){
		
		Response response=given()
			.pathParam("username", userName)
			.accept(ContentType.JSON)
			
			
		.when()
			.get(Routes.get_url);
		
		return response;
		
		
	}
	
	public static Response updateUser(String userName, User payload) {
		
		Response response=given()
				.pathParam("username", userName)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				
				.when()
					.put(Routes.put_url);
		
		return response;
		
	}
	
	public static Response deleteUser(String userName) {
		
		Response response=given()
				.pathParam("username", userName)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				
				
				.when()
					.delete(Routes.delete_url);
		
		return response;
		
	}
	
public static Response createUserWithArray(User payload){
	
		String post_url_witharray=getURL().getString("post_url_witharray");
		
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
		.when()
			.post(post_url_witharray);
		
		return response;
		
		
	}

}
