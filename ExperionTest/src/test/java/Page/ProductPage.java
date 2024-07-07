package Page;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage 
{
	@FindBy(xpath="//select[@class='product_sort_container']")
	private WebElement selectFilter ;
	
	@FindBy(xpath="//*[@id=\"add-to-cart\"]")
	private WebElement btnAddToCart ;
	
	@FindBy(xpath="//*[@id=\"shopping_cart_container\"]")
	private WebElement shoppingCartContainer;
	
	@FindBy(xpath = "//*[@id=\"back-to-products\"]")
	private WebElement btnBacktoPdt;
	
	@FindBy(xpath = "//*[@id=\"remove\"]")
	private WebElement btnRemove;
	
	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]")
	private WebElement btnShoppingCart;
	
	@FindBy(xpath = "//*[@id=\"checkout\"]")
	private WebElement btnCheckout;
	
	@FindBy(xpath = "//*[@id=\"first-name\"]")
	private WebElement firstName;
	
	@FindBy(xpath = "//*[@id=\"last-name\"]")
	private WebElement lastName;
	
	@FindBy(xpath = "//*[@id=\"postal-code\"]")
	private WebElement postalCode;
	
	@FindBy(xpath="//*[@id=\"continue\"]")
	private WebElement btnContinue; 
	
	@FindBy(xpath = "//*[@id=\"finish\"]")
	private WebElement btnFinish;
	
	@FindBy(xpath = "//h2[@class='complete-header']")
	private WebElement confirmationmsg;
	
	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	private WebElement subTotal;
	
	@FindBy(xpath = "//div[@class='summary_total_label']")
	private WebElement total;
	
	@FindBy(xpath = "//span[@class=\"active_option\"]")
	private WebElement activeoption;
		
	WebDriverWait wait;
	WebDriver driver;
	
	
	public ProductPage(WebDriver driver) 
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		
	}
	
	public void filterByName(String value)
	{
		Select select = new Select(selectFilter);
		select.selectByVisibleText(value);
	}
	
	public void selectProduct(String productName)
	{
		WebElement pdt = driver.findElement(By.xpath("//div[contains(text(),'"+productName+"')]"));
		wait.until(ExpectedConditions.elementToBeClickable(pdt)).click();
	}
	
	public void clickOnAddToCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart)).click();
		Assert.assertEquals("Remove", btnRemove.getText());		
	}
	public void clickOnshoppingCartLoink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCartContainer)).click();
		
	}
	
	public void clickOnBackToPdt()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnBacktoPdt)).click();

	}
	public void clickOnshoppingCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnShoppingCart)).click();
	}
	
	public void clickOnCheckout()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnCheckout)).click();
	}
	
	public void fillYourInformation(String firstname,String lastname,String postalcode)
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys(firstname);
		wait.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys(firstname);
		wait.until(ExpectedConditions.elementToBeClickable(postalCode)).sendKeys(postalcode);
		wait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();

	}
	
	public void selectProducts()
	{
		List <WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
		
		for(int i =0;i<3 && i<products.size();i++)
		{
            WebElement addToCartButton = products.get(i).findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
            addToCartButton.click();

		}
		
	}
	

	public void getPriceDetais()
	{
		System.out.println("Price Details");
		System.out.println(subTotal.getText());
		System.out.println(total.getText());
	}
	public void clickOnFinish()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnFinish)).click();

	}
	
	public String getConfirmationMsg()
	{
		wait.until(ExpectedConditions.visibilityOf(confirmationmsg));
		return confirmationmsg.getText();
	}
	
	public String getActiveFilterOption()
	{
		wait.until(ExpectedConditions.visibilityOf(activeoption));
		return activeoption.getText();
	}
	
	
	
	
	 

}
