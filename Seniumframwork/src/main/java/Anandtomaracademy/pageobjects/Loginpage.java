package Anandtomaracademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Anandtomaracademy.abstractmethods.Abstractclassparent;

public class Loginpage extends Abstractclassparent {
	WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement Passcode;
	
	@FindBy(css=".btn")
	WebElement loginbutton;
//     .ng-tns-c4-44.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
	
	
	public void goTo(){
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		
	}
	
	public Cartoptions actionclasses(String emailname, String passwrds) {
		useremail.sendKeys(emailname);
		Passcode.sendKeys(passwrds);
		loginbutton.click();
		Cartoptions cartoption = new Cartoptions(driver);
		return cartoption;
	}
	public String geterrormessage() {
		elementtobevisble(errormessage);
		return errormessage.getText();
	}
	
	
}

