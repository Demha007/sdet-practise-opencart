package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"sanity","master"})
	public void verify_login() {
		logger.info("**** Starting TC_002_LoginTest ****");
		logger.debug("Capturing Application debug logs....");
		try {
		//home page
		Homepage hp=new Homepage(dr);
		hp.clickMyAccount();
		logger.info("clicked on myaccount link on the homepage..");
		hp.clkLogin(); //login link under myaccount
		logger.info("clciked on login link under my account..");
		
		//login page
		LoginPage lp = new LoginPage(dr);
		lp.setEmail(p.getProperty("email"));
		logger.info("Entering Valid email..");
		lp.setPassword(p.getProperty("password"));
		logger.info("Entering valid Password..");
		lp.btnclick();//login button
		logger.info("Clicked on login button..");
		
		//My account page
		MyAccountPage mp = new MyAccountPage(dr);
		boolean targetPage = mp.isMyAccExist();
		if(targetPage==true) {
			logger.info("Login test passed..");
			Assert.assertTrue(true);
		}
		else {
			logger.error("login failed...");
			Assert.fail();
		}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Finished TC_002_LoginTest ***");
	}
}
