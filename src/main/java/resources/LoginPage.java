package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	protected WebDriver driver;
	
	private By email = By.id("emailLogin_MD");
	private By password = By.id("passwordLogin_MD");
	private By loginButton = By.id("btnLoginSend");
	private By registerButton = By.xpath("//a[@href='/registrarme']");
	private By forgotPassword = By.xpath("//a[@href='/forgotpassword']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail_textBox() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword_textBox() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
	public WebElement getregisterButton() {
		return driver.findElement(registerButton);
	}
	
	public WebElement getForgotPassword() {
		return driver.findElement(forgotPassword);
	}

}
