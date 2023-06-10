package tests;

import org.testng.annotations.Test;

import Utilities.Utility;
import baseContainer.TestBase2;
import pages.loginPage;

public class loginTest extends TestBase2 {
	@Test
	public void invalidLogin() throws Exception {
		
		Utility utils = new Utility();
		loginPage logn = new loginPage(driver);
		
		logn.clickAvatarIcon();
		logn.clickEmail();
		logn.typeInEmailField("username");  //This is where am having the failure
//		logn.clearPasswordField();
//		logn.typeInEmailField("password");
//		logn.clicksubmitloginButton();
		
	}
	
}
