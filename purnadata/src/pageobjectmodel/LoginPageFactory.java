package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

	WebDriver driver;

	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement enterUsername;

	@FindBy(id = "password")
	WebElement enterPassword;

	@FindBy(name = "submit")
	WebElement btnLogin;

	@FindBy(xpath = "//span[contains(text(),'Main')]")
	WebElement openMenuOption;

	@FindBy(xpath = "//a[@href='customer_dashboard.php']")
	WebElement selectCustomerOption;

	public void enterUsername(String uname) {
		enterUsername.sendKeys(uname);
	}

	public void enterPassword(String pass) {
		enterPassword.sendKeys(pass);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void openMainMenu() {
		openMenuOption.click();
	}

	public void selectCustomerOption() {
		selectCustomerOption.click();
	}

}
