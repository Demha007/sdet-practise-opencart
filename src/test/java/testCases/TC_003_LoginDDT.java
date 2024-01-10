package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDt(String email, String password, String res) {

		logger.info("***Starting TC_003_LoginDDT ");
		try {
		// home page
		Homepage hp = new Homepage(dr);
		hp.clickMyAccount();

		hp.clkLogin(); // login link under myaccount

		// login page
		LoginPage lp = new LoginPage(dr);
		lp.setEmail(email);

		lp.setPassword(password);

		lp.btnclick();// login button

		// My account page
		MyAccountPage mp = new MyAccountPage(dr);
		boolean targetPage = mp.isMyAccExist();

		if (res.equalsIgnoreCase("valid")) {
			if (targetPage == true) {
				mp.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		if (res.equalsIgnoreCase("invalid")) {
			if (targetPage == true) {
				mp.clickLogout();
				Assert.assertTrue(false);

			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***Finished TC_003_LoginDDT***");
	}
}
