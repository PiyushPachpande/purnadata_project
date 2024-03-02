package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageOjectModel {

	WebDriver driver;
	
	public LoginPageOjectModel(WebDriver driver) {
		this.driver = driver;
	}
	
	By userName = By.id("username");
	By password = By.id("password");
	By btnLogin = By.name("submit");
	By mainDropdown = By.xpath("//span[contains(text(),'Main')]");
	By selectCustomerfromMain = By.xpath("//a[@href='customer_dashboard.php']");
	
	public void enterUsername(String uname) {
		driver.findElement(userName).sendKeys(uname);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin() {
		driver.findElement(btnLogin).click();;
	}
	
	public void openMainMenu() {
		driver.findElement(mainDropdown).click();
	}
	
	public void selectCustomerOption() {
		driver.findElement(selectCustomerfromMain).click();
	}

}

