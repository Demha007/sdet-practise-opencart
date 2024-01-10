package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;

public class TC_001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups= {"regression","master"})
	public void verify_account_registratio() {
		
		logger.info("****...starting TC_001_AccountRegistrationTest...****");
		try {
		
		Homepage hp=new Homepage(dr);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickMyRegister();
		logger.info("Clicked on Register link");
		
		logger.info("Entering Customer Inforamtion");
		AccountRegistrationPage reg = new AccountRegistrationPage(dr);
		reg.setFisrtName(randomString().toUpperCase());
		reg.setLastName(randomString().toUpperCase());
		reg.setEmail(randomString()+"@gmail.com");
		reg.setTele(randomNumber());
		
		String password = randomAlphaNumeric();
		
		reg.setPass(password);
		reg.setConfirm(password);
		
		reg.clkAgree();
		reg.clkContinue();
		logger.info("clicked on continue");
		String confmMsg = reg.getConfirmationMSG();
		logger.info("Validating Expected Message...");
		if(confmMsg.equals("Your Account Has Been Created!")){
			logger.info("test passed...");
			Assert.assertTrue(true);
		}
		else {
			logger.info("test failed...");
			Assert.fail();
		}
//	Assert.assertEquals(confmMsg,"Your Account Has Been Created!!!");
		}
		catch(Exception e) {
			logger.error("test failed...:/ ");
			Assert.fail();
		}
		logger.info("***...finishing of TC_001_AccountRegistrationTest...****");
		
	}
	

}
