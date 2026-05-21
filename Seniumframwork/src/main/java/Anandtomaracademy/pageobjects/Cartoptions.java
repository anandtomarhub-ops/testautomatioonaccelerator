package Anandtomaracademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Anandtomaracademy.abstractmethods.Abstractclassparent;

public class Cartoptions extends Abstractclassparent {
	WebDriver driver;
	
	public Cartoptions(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css= ".col-lg-4")
	List<WebElement> product;	
	@FindBy(css= ".ng-animating")
	WebElement animating;	
	By productvisibility = By.cssSelector(".col-lg-4");
	By elementclickable = By.cssSelector(".card-body button:last-of-type");
	By toastcontainer = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getmeproduct(){
		elementtobevisble(productvisibility);
		return product;
		
	}
	public WebElement getproductbyName(String name) {
		WebElement prod = getmeproduct().stream().filter(products->
		products.findElement(By.tagName("b")).getText().equals(name)).findFirst().orElseThrow(() -> 
                new RuntimeException("Product not found: " + name));

		return prod;
	}
	
	
	public void addtocard(String name){
		WebElement addtocard =getproductbyName(name).findElement(elementclickable);
		
		elementclickable(elementclickable);
		jsClick(addtocard);
		elementtobevisble(toastcontainer);
		elementstobeinvisible(animating);
}

		//js.executeScript("arguments[0].click();", addtocard);
}

	
	



