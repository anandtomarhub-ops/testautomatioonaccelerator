package anandtomaracademy.pageobject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Anandtomaracademy.pageobjects.Cartoptions;
import Anandtomaracademy.pageobjects.Checkoutpage;
import Anandtomaracademy.pageobjects.Confirmationpage;
import Anandtomaracademy.pageobjects.Loginpage;
import Anandtomaracademy.pageobjects.cartpage;
import Anandtomaracademy.pageobjects.orderpage;
import anandtomaracademy.resources.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import java.io.File;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class SupertestTest extends BaseTest{
String name2 = "ADIDAS ORIGINAL";
String Productname = "ZARA COAT 3";

	@Test(dataProvider="getdata", groups="Submitorder")
	public void submittest(HashMap<String, String> input) throws IOException, InterruptedException{
		
		// TODO Auto-generated method stub
		
		Cartoptions cartoption = loginpage.actionclasses(input.get("email"), input.get("Password"));
		
		List<WebElement> product = cartoption.getmeproduct();
		cartoption.addtocard(input.get("Productname"));
		cartoption.addtocard(name2);
		cartpage cp = loginpage.goTocart();
		
		cp.cartproducts();
		Boolean match = cp.verifyproducts(input.get("Productname"));
		Assert.assertTrue(match, "Product not found: " + input.get("Productname"));
		//cp.checkoutpage();
		Checkoutpage checkoutpage = cp.checkoutpage();
		checkoutpage.inputfordropdown("India");
		Confirmationpage cc =checkoutpage.placeorder();
		String message = cc.messages();			
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
		
		
		//driver.findElement(By.cssSelector(".ng-animating"))
	}
	
	@Test(dependsOnMethods = {"submittest"})
	public void orders(){
		Cartoptions cartoption = loginpage.actionclasses("Anandtomar@gmail.com", "Anand@123");
		orderpage order = cartoption.gotoorderpage();
		Assert.assertTrue(order.verifyoderdisplay(Productname));
	}
	@DataProvider
	public Object[][] getdata() throws IOException {
	List<HashMap<String, String>> data = getjsondatareader(System.getProperty("user.dir") +
            "\\src\\test\\java\\anandtomaracademy\\data\\resources.json");
    
		
		return new Object[][] {{data.get(0)},{data.get(1)}};

	}
	
		
/*@DataProvider
	public Object[][] getdata() {
		//return new Object [][] {{"Anandtomar@gmail.com", "Anand@123","ZARA COAT 3"},{}};
		HashMap<String, String> map = new HashMap();
		
		return new Object[][] {{map},{map1}};

	}
	/*@DataProvider
	public Object[][] getdata() {
		//return new Object [][] {{"Anandtomar@gmail.com", "Anand@123","ZARA COAT 3"},{}};
		HashMap<String, String> map = new HashMap();
		map.put("email", "Anandtomar@gmail.com");
		map.put("Password", "Anand@123");
		map.put("Productname", "ZARA COAT 3");
		
		HashMap<String, String> map1 = new HashMap();
		map.put("email", "Anandtomar@gmail.com");
		map.put("Password", "Anand@123");
		map.put("Productname", "ZARA COAT 3");
		return new Object[][] {{map},{map1}};

	}
*/

}