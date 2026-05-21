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

public class orderpage extends Abstractclassparent {
		WebDriver driver;
		@FindBy(css= "tr td:nth-child(3)")
		List<WebElement> orderlist; 
		
		@FindBy(css= ".totalRow button")
		WebElement button; 
		
		By cartlocator = By.cssSelector(".cartSection h3");
	
		
		
	public orderpage(WebDriver driver) {
		
		super(driver);		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public Boolean verifyoderdisplay(String name) {
		Boolean match = orderlist.stream().anyMatch(p -> p.getText().trim().equalsIgnoreCase(name));
		return match;
	}
	
	
}



