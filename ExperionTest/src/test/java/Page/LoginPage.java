package Page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	@FindBy(xpath="//*[@id=\"user-name\"]")
	private WebElement txtusername;
	
	@FindBy(xpath = "//*[@id=\"password\"]")
	private WebElement txtpassword;
	
	@FindBy(xpath ="//*[@id=\"login-button\"]" )
	private WebElement loginBtn;
	
	WebDriverWait wait;
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);

	}
	
	public void inputUserName(String userName)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtusername)).sendKeys(userName);
	}
	public void inputPassword(String password)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtpassword)).sendKeys(password);
	}
	public void clickOnLoginButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
	}
	
	public void doLogin(String userName,String password)
	{
		inputUserName(userName);
		inputPassword(password);
		clickOnLoginButton();
	}
	
	

}
