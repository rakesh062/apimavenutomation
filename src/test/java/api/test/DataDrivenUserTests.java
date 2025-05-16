package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenUserTests {
	
	public User userPayLoad=new User();
	
	@Test(priority=1, dataProvider="Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String userName, String firstName, String lastName, String emailId, String password, String phoneNum) {
		
		userPayLoad.setId(Integer.parseInt(userId));
		userPayLoad.setUsername(userName);
		userPayLoad.setFirstName(firstName);
		userPayLoad.setLastName(lastName);
		userPayLoad.setEmail(emailId);
		userPayLoad.setPassword(password);
		userPayLoad.setPhone(phoneNum);
		
		Response response=userEndPoints.createUser(userPayLoad);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2, dataProvider ="Usernames", dataProviderClass = DataProviders.class)
	public void testGetUserByUserName(String userName) {
		Response response=userEndPoints.readUser(userName);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
