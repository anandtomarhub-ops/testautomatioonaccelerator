package anandtomaracademy.pageobject;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Anandtomaracademy.pageobjects.Cartoptions;
import Anandtomaracademy.pageobjects.Checkoutpage;
import Anandtomaracademy.pageobjects.Confirmationpage;
import Anandtomaracademy.pageobjects.Loginpage;
import Anandtomaracademy.pageobjects.cartpage;
import anandtomaracademy.resources.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class errorvalidationTest extends BaseTest{

	@Test(groups = {"Errorhandling"})
	public void loginpageerrorvalidation() throws IOException, InterruptedException{
		
		// TODO Auto-generated method stub
		String name = "ZARA COAT 3";
		String name2 = "ADIDAS ORIGINAL";
		Cartoptions cartoption = loginpage.actionclasses("Anandtomar@gail.com", "Anand@123");
		Assert.assertEquals("Incorrect email password.", loginpage.geterrormessage());
		//driver.findElement(By.cssSelector(".ng-animating"))
	}
	@Test
	public void producterrorvalidation() throws IOException, InterruptedException{
		
		// TODO Auto-generated method stub
		String name = "ZARA COAT 3";
		String name2 = "ADIDAS ORIGINAL";
		Cartoptions cartoption = loginpage.actionclasses("babusingh@123.com", "System45");
		
		List<WebElement> product = cartoption.getmeproduct();
		cartoption.addtocard(name);
		cartoption.addtocard(name2);
		cartpage cp = loginpage.goTocart();
		
		cp.cartproducts();
		Boolean match = cp.verifyproducts("ZARA COAT 5");
		Assert.assertFalse(match, "Product not found: " + name);


	}
}