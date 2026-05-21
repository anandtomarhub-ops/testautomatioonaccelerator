package anandtomaracademy.pageobject;

import java.awt.Desktop.Action;
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

import Anandtomaracademy.pageobjects.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Standalone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "ZARA COAT 3";
		String name2 = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		

		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Loginpage loginpage = new Loginpage(driver);
		
		driver.findElement(By.id("userEmail")).sendKeys("Anandtomar@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Anand@123");
		driver.findElement(By.cssSelector(".btn")).click();
		loginpage.actionclasses("Anandtomar@gmail.com", "Anand@123");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));		
		List <WebElement> product = driver.findElements(By.cssSelector(".col-lg-4"));
		//Zara coat
		WebElement prod = product.stream().filter(products->
		products.findElement(By.tagName("b")).getText().equals(name)).findFirst().orElse(null);
		
		WebElement addtocard =prod.findElement(By.cssSelector(".card-body button:last-of-type"));
		wait.until(ExpectedConditions.elementToBeClickable(addtocard));
		js.executeScript("arguments[0].click();", addtocard);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//Addidas
		WebElement prod1 = product.stream().filter(products->
		products.findElement(By.tagName("b")).getText().equals(name2)).findFirst().orElse(null);		
		WebElement addtocard1 =prod1.findElement(By.cssSelector(".card-body button:last-of-type"));
		wait.until(ExpectedConditions.elementToBeClickable(addtocard1));
		js.executeScript("arguments[0].click();", addtocard1);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		WebElement button1 =driver.findElement(By.cssSelector("[routerlink*='cart']"));
		wait.until(ExpectedConditions.elementToBeClickable(button1));
		js.executeScript("arguments[0].click();", button1);		
		//next page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		List<WebElement> cartproduct = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartproduct.stream().anyMatch(p -> p.getText().trim().equalsIgnoreCase(name));
		Assert.assertTrue(match, "Product not found: " + name);	
		//checkoutbutton
		WebElement button = driver.findElement(By.cssSelector(".totalRow button"));
		wait.until(ExpectedConditions.elementToBeClickable(button));
		js.executeScript("arguments[0].click();", button);		
		Actions a = new Actions(driver);
		WebElement ind = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Select Country']")));
		a.sendKeys(ind, "India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		WebElement e = driver.findElement(By.cssSelector(".ta-results button:last-of-type"));
		a.doubleClick(e).build().perform();
		WebElement ee = wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(".actions a"))));
		js.executeScript("arguments[0].click();",ee);
		//js.executeScript("arguments[0].click();", addtocard1);
		
		WebElement str = 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));
		String message = str.getText();
		
		System.out.println(message);
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		
		
		System.out.println("script run succesfully");
		//driver.close();
		//driver.findElement(By.cssSelector(".ng-animating"))
	}

}
