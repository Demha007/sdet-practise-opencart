package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.text.SimpleDateFormat;
public class BaseClass {
	public WebDriver dr;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os", "browser"})
	public void setup(String os,String br) throws IOException {
		
		//Loading proprties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		//Loading Log4j file
		logger=LogManager.getLogger(this.getClass()); //log4j
		
		//launching browser based on condition
		switch(br.toLowerCase()) 
		{
		case "chrome": dr=new ChromeDriver();break;
		case "edge": dr = new EdgeDriver();break;
		default : System.out.println("No matching browser..");
				return;
		}
		
		dr.manage().deleteAllCookies();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		dr.get(p.getProperty("appURL"));
		dr.manage().window().maximize();
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() {
		dr.quit();
	}
	
	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	public String randomNumber() {
		String generatedString= RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric() {
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		
		
		return (str+"@"+num);
	}
	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts = (TakesScreenshot)dr;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp;
		File targetFile = new File(targetFilePath);
		
		srcFile.renameTo(targetFile);
		
		return targetFilePath;
	}
}
