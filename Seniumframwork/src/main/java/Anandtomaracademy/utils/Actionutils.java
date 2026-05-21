package Anandtomaracademy.utils;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actionutils {


		WebDriver driver;
		Actions actions;
		// TODO Auto-generated constructor stub
		public Actionutils(WebDriver driver) {
			this.driver = driver;
			this.actions = new Actions(driver);
			
		}		

	    public void type(WebElement element, String text) {
	        actions.sendKeys(element, text).build().perform();
	    }

	    public void doubleClick(WebElement element) {
	        actions.doubleClick(element).build().perform();
	    }

	    public void click(WebElement element) {
	        actions.moveToElement(element).click().build().perform();
	    }

	    public void hover(WebElement element) {
	        actions.moveToElement(element).build().perform();
	    }

	
	}


