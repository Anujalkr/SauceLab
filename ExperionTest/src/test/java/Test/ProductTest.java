package Test;

import org.testng.annotations.Test;

import Page.LoginPage;
import Page.ProductPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductTest {
	WebDriver driver;
	LoginPage loginpage;
	ProductPage sorting;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

	}

	@Test(priority = 1,description = "Verify the sorting of products by inputtong option(Price / Name)")
	public void verifyProductSorting() 
	{
		loginpage = new LoginPage(driver);
		sorting = new ProductPage(driver);
		loginpage.doLogin("standard_user", "secret_sauce");
		sorting.filterByName("Price (high to low)");
		Assert.assertEquals("Price (high to low)", sorting.getActiveFilterOption());
		
	}
	
	@Test(priority = 2,description = "Verify the user can add lowest 3 products and add to cart")
	public void addThreeLowestPricedProductToCart()
	{
		loginpage = new LoginPage(driver);
		sorting = new ProductPage(driver);
		loginpage.doLogin("standard_user", "secret_sauce");
		sorting.filterByName("Price (low to high)");
		Assert.assertEquals("Price (low to high)", sorting.getActiveFilterOption());
		sorting.selectProducts();
		sorting.clickOnshoppingCart();
		sorting.clickOnCheckout();
		sorting.fillYourInformation("Thoams", "Mathew", "776655");
		sorting.getPriceDetais();
		sorting.clickOnFinish();
		Assert.assertEquals("Thank you for your order!", sorting.getConfirmationMsg());
	
	}
	
	@AfterMethod()
	public void tearDown()
	{
//		driver.close();
	}


}
