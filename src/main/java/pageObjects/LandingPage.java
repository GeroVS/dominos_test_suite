package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private By menu = By.xpath("//a[@data-element='pizza']");
	private By armaMenu = By.xpath("//a[@data-element='pizzabuilder']");
	private By promo = By.xpath("//a[@data-element='promociones']");
	private By compl = By.xpath("//a[@data-element='adicionales']");
	private By carrito = By.xpath("//a[@data-element='carrito']");
	private By login = By.xpath("//a[@data-element='login']");
	private By titulo = By.id("cbsModalWncuentes");
	
	private WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getMenu() {
		return driver.findElement(menu);
	}
	
	public WebElement getArmaMenu() {
		return driver.findElement(armaMenu);
	}
	
	public WebElement getPromo() {
		return driver.findElement(promo);
	}
	
	public WebElement getComplement() {
		return driver.findElement(compl);
	}
	
	public WebElement getCarrito() {
		return driver.findElement(carrito);
	}
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public WebElement getTitulo() {
		return driver.findElement(titulo);
	}
}
