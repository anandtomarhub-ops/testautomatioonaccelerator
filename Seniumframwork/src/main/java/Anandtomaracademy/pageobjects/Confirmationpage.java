package Anandtomaracademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Anandtomaracademy.abstractmethods.Abstractclassparent;

public class Confirmationpage extends Abstractclassparent{
	WebDriver driver;

	public Confirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	By mytext = By.cssSelector(".hero-primary");
	public String messages() {
		String str = elementtobevisble(mytext).getText();
		return str;
	}

}
