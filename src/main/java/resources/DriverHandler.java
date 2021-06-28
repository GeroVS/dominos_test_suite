package resources;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverHandler {
	
	static JavascriptExecutor js;
	
	public void performAction(WebDriver driver, SeleniumActions action, WebElement element, String value) {
		js = ((JavascriptExecutor)driver);
		
		switch(action) {
		case Navigate:
			navigate(driver, value);
			break;
		case Click:
			click(element);
			break;
		case Type:
			type(element, value);
		case AltType:
			altType(element, value);
		case Highlight:
			highlight(element);
		default:
			break;
		}
	}
	
	private void navigate(WebDriver driver, String value) {
		try {
			String url;
			if(!value.contains("http://") || !value.contains("https://")) {
				url = "http://" + value;
			}else
				url = value;
			
				driver.navigate().to(url);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void click(WebElement element) {
		try {
			highlight(element);
			element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void type(WebElement element, String value) {
		try {
			
			highlight(element);
			element.sendKeys(value);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void altType(WebElement element, String value) {
		try {
			
			highlight(element);
			element.click();
			element.sendKeys(value);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void highlight(WebElement element) {
		String border;
		border = "#f00 solid 5px";
		js.executeScript("arguments[0].style.outline = '" + border + "'; ", element);
	}

}
