package Anandtomaracademy.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Anandtomaracademy.abstractmethods.Abstractclassparent;
import Anandtomaracademy.utils.Actionutils;

public class Checkoutpage extends Abstractclassparent{
	WebDriver driver;
	//Actionutils action;
	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//this.action = new Actionutils(driver);
	}
	
	By india = By.cssSelector("input[placeholder='Select Country']");

	By dropdown = By.cssSelector(".ta-results");
	By option = By.cssSelector(".ta-results button:last-of-type");
	By submit = By.cssSelector(".actions a");
	By text =  By.cssSelector(".hero-primary");

	
	public void inputfordropdown(String name) {
		WebElement ind = elementtobevisble(india);
		Actions a = new Actions(driver);
			
		//WebElement ind = elementtobevisble(india);
		
		a.sendKeys(ind, name).build().perform();
		elementtobevisble(dropdown);
		WebElement e = driver.findElement(option);
		a.doubleClick(e).build().perform();
		
	}
	public Confirmationpage placeorder() {
		elementclickable(submit);
		WebElement placeord = driver.findElement(submit);
		jsClick(placeord);
		Confirmationpage cc = new Confirmationpage(driver);
		return cc;
	}

	
}
