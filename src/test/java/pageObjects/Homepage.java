package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {
	
	WebDriver dr;
	public Homepage(WebDriver dr) {
		super(dr);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement clkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement clkRegister;
	
	@FindBy(linkText="Login")
	WebElement linkLogin;
	
	//Actions
	public void clickMyAccount() {
		clkMyaccount.click();
	}
	public void clickMyRegister() {
		clkRegister.click();
	}
	
	public void clkLogin() {
		linkLogin.click();
	}
}
