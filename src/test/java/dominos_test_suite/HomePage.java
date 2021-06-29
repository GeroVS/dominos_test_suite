package dominos_test_suite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.DriverBuilder;
import resources.DriverHandler;
import resources.DriverType;
import resources.SeleniumActions;

public class HomePage extends DriverHandler{
	
	WebDriver driver;
	Properties prop;
	

	@BeforeTest
	public void initialize() throws IOException {
		prop = new Properties();

		String path = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		
		prop.load(fis);
		String browser = prop.getProperty("browser").toLowerCase();
		
		switch(browser) {
		case "chrome":
			driver = new DriverBuilder(DriverType.Chrome)
			.withDefaultOptions()
			.build();
			break;
		case "firefox":
			driver = new DriverBuilder(DriverType.FireFox)
			.withDefaultOptions()
			.build();
			break;
		case "ie":
			driver = new DriverBuilder(DriverType.IE)
			.withDefaultOptions()
			.build();
			break;
		}
			
	}
	
	@Test
	public void ValidateTitle() {
		performAction(driver, SeleniumActions.Navigate, null, prop.getProperty("url"));
		
		LandingPage lp = new LandingPage(driver);
		performAction(driver, SeleniumActions.Highlight, lp.getTitulo(), null);
		Assert.assertEquals(lp.getTitulo().getText(), "ELIGE TU PIZZA");
	}
	
	@AfterTest
	public void closeWindow() {
		driver.close();
	}
}
