package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	
	public static Logger logger;
	
	@BeforeClass
	public void setUp() {
		
		faker=new Faker();
		
		userPayload= new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger= LogManager.getLogger(this.getClass());
	
	}
	
	
	@Test(priority = 1)
	public void testPostUser() {
		
		logger.info("***************************** Creating user ********************************");
		
		//System.out.println(this.userPayload.getUsername());
		Response response=userEndPoints.createUser(userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***************************** User created ********************************");
		
	}
	
	@Test(priority = 2)
	public void testGetUserByusername() {
		
		//System.out.println(this.userPayload.getUsername());
		Response response=userEndPoints.readUser(this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 3)
	public void testupdateUserByusername() {
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		System.out.println(this.userPayload.getUsername());
		Response response=userEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 4)
	public void testdeleteUserByusername() {
		
		System.out.println(this.userPayload.getUsername());
		Response response=userEndPoints.deleteUser(this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	//Test case to test post method with array inputs
	@Test(priority = 5)
	public void testPostUserWithArray() {
		
		logger.info("***************************** Creating user with Array ********************************");
		
		//System.out.println(this.userPayload.getUsername());
		Response response=userEndPoints.createUserWithArray(userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("***************************** User created with Array ********************************");
		
	}

}
