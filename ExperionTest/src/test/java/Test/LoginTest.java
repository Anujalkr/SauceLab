package Test;

import org.testng.annotations.Test;

import Page.LoginPage;
import utilities.ReadFromExcel;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginTest 
{
	WebDriver driver;
	LoginPage loginpage;
	
	 @BeforeMethod
	  public void beforeMethod() 
	  {
		  driver = new ChromeDriver();
		  driver.get("https://www.saucedemo.com/");
		  driver.manage().window().maximize();	  
	  }
	 
  @Test(dataProviderClass = ReadFromExcel.class,dataProvider = "LoginCredentials",
		  description = "Verify the user can login using valid and invalid credentials ")
  public void verifyValidLoginFunctionality(String username,String pwd) 
  {
	  loginpage = new LoginPage(driver);
	  loginpage.inputUserName(username);
	  loginpage.inputPassword(pwd);
	  loginpage.clickOnLoginButton();
	  
  }
 

  @AfterMethod
  public void afterMethod() 
  {
	  driver.close();
  }

}
