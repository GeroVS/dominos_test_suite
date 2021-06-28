package resources;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverBuilder {
	
	private DriverType driverType;
	private String[] defaulOptions;
	public Properties props;
	
	public DriverBuilder(DriverType driverType) {
		this.driverType = driverType;
	}
	
	public DriverBuilder withDefaultOptions() {
		switch(driverType) {
		case IE:
			defaulOptions = new String[] {"ignoreZoomSettings", "ignoreProtectedModeSettings", "requireWindowFocus"};
			
		case Chrome:
			defaulOptions = new String[] {"disable-extensions", "--disable-notifications", "--start-maximized"};
			
		case FireFox:
			defaulOptions = new String[] {"marionette"};
		}
		
		return this;
	}
	
	public WebDriver build() {
		WebDriver driver = null;
		
		switch (driverType) {
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\gera_\\Downloads\\chromedriver.exe");
			ChromeOptions chromeOptions = (ChromeOptions) getOptions(defaulOptions);
			driver = new ChromeDriver(chromeOptions);
			break;
		case FireFox:
			System.setProperty("webdriver.firefox.driver", "");
			FirefoxOptions firefoxOptions = (FirefoxOptions) getOptions(defaulOptions);
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case IE:
			System.setProperty("webdriver.internetexplorer.driver", "");
			InternetExplorerOptions iEOptions = (InternetExplorerOptions) getOptions(defaulOptions);
			driver = new InternetExplorerDriver(iEOptions);
			break;
		}
		
		return driver;
	}
	
	private Object getOptions(String ...opts) {
		switch (driverType) {
		case Chrome:
			ChromeOptions optionsC = new ChromeOptions();
			return optionsC.addArguments(opts);

		case FireFox:
			FirefoxOptions optionsF = new FirefoxOptions();
			return optionsF.addArguments(opts);
			
		case IE:
			InternetExplorerOptions optionsI = new InternetExplorerOptions();
			return optionsI.ignoreZoomSettings()
					.introduceFlakinessByIgnoringSecurityDomains()
					.requireWindowFocus();
		}
		return null;
	}

}
