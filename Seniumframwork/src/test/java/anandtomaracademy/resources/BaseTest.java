package anandtomaracademy.resources;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

//import java.awt.Dimension;
import java.io.File;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.devtools.v145.filesystem.model.File;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Anandtomaracademy.pageobjects.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Loginpage loginpage;

	public WebDriver initializebrowser() throws IOException {
		System.out.println("=== BROWSER VALUE === " + System.getProperty("browser"));
		// TODO Auto-generated constructor stub
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\anandtomracademy\\globalresources\\browserresources");
		p.load(fis);
		
		String browsername = System.getProperty("browser") != null
        ? System.getProperty("browser")
        : p.getProperty("browser").trim().toLowerCase();
		browsername = browsername.trim().toLowerCase();


		if (browsername.contains("chrome")) {

			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();

			if (browsername.contains("headless")) {
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
    }

			driver = new ChromeDriver(options);
		}

			
		
		else if(browsername.equalsIgnoreCase("edge")){

			//System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();

    }
		else if(browsername.equalsIgnoreCase("FireFox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
	}

		else
                throw new RuntimeException("Browser not supported: " + browsername);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
		public List<HashMap<String, String>> getjsondatareader(String filepath) throws IOException {
		// TODO Auto-generated constructor stub

				String jsonContent = FileUtils.readFileToString(
                new File(filepath),StandardCharsets.UTF_8);


				ObjectMapper mapper = new ObjectMapper();
				List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){});
				return data;
	}
		public String takescreenshot(String testcasename, WebDriver driver) throws IOException {
			File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
			FileUtils.copyFile(src, file);
			return System.getProperty("user.dir") + "//reports//" + testcasename + ".png";
	}
		
		
		@BeforeMethod(alwaysRun=true)
		public Loginpage lunchapplication() throws IOException {
		driver = initializebrowser();
		loginpage = new Loginpage(driver);
		loginpage.goTo();
		return loginpage;
	}
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		System.out.println("script run succesfully");
		driver.close();
	}
	
}
