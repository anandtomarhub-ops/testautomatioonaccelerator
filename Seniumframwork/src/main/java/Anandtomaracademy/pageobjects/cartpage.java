package Anandtomaracademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Anandtomaracademy.abstractmethods.Abstractclassparent;

public class cartpage extends Abstractclassparent {
		WebDriver driver;
		@FindBy(css= ".cartSection h3")
		List<WebElement> cartproduct; 
		@FindBy(css= ".totalRow button")
		WebElement button; 
		
		By cartlocator = By.cssSelector(".cartSection h3");
		
	public cartpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public List<WebElement> cartproducts(){
		elementtobevisble(cartlocator);
		return cartproduct;
	}
	
	public Boolean verifyproducts(String name) {
		Boolean match = cartproduct.stream().anyMatch(p -> p.getText().trim().equalsIgnoreCase(name));
		return match;
	}
	
	public Checkoutpage checkoutpage() throws InterruptedException {
		elementclickableele(button);
		jsClick(button);
		Thread.sleep(1000);
		Checkoutpage checkoutpag = new Checkoutpage(driver);
		return checkoutpag;
		
	}
	
}



