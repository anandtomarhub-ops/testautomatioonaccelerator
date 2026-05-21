package Anandtomaracademy.abstractmethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Anandtomaracademy.pageobjects.cartpage;
import Anandtomaracademy.pageobjects.orderpage;
import io.opentelemetry.sdk.autoconfigure.spi.Ordered;

public class Abstractclassparent {
	WebDriver driver;
	public Abstractclassparent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css= "[routerlink*='cart']")
	WebElement cart;
	@FindBy(css= "[routerlink*='myorders']")
	WebElement orders;
	
	public cartpage goTocart() {
		elementclickableele(cart);
		jsClick(cart);
		cartpage cp = new cartpage(driver);
		return cp;
	}
	public orderpage gotoorderpage() {
		elementclickableele(orders);
		jsClick(orders);
		orderpage or = new orderpage(driver);
		return or;
	}
		
				
	public WebElement elementtobevisble(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(findby));		
	}
	public WebElement elementtobevisble(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(ele));		
	}
	public void elementclickable(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(findby));
	}
	public void elementclickableele(WebElement web) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(web));
	}
	
	public void elementstobeinvisible(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	

	public void jsClick(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", element);
	    }

	    // ✅ Optional: scroll into view (very useful)
	public void jsScrollIntoView(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", element);
	    }

}
