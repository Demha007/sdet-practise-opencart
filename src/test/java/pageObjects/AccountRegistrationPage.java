package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	WebDriver dr;
	
	public AccountRegistrationPage(WebDriver dr) {
		super(dr);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTele;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPass;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfrm;
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement clkContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFisrtName(String fname) {
		txtFname.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTele(String tele) {
		txtTele.sendKeys(tele);
	}
	public void setPass(String pass) {
		txtPass.sendKeys(pass);
	}
	public void setConfirm(String cnfirm) {
		txtConfrm.sendKeys(cnfirm);
	}
	public void clkAgree() {
		chkAgree.click();
	}
	public void clkContinue() {
		clkContinue.click();
	
	
		/*
		 * Actions act = new Actions(dr);
		 * act.moveToElement(clkContinue).click().perform();
		 * 
		 * JavascriptExecutor js= (JavascriptExecutor)dr;
		 * js.executeScript("arguments[0].click();",clkContinue);
		 */
	}
	public String getConfirmationMSG() {
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
	}
	
}
