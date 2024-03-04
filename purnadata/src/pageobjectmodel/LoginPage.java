package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")      //WebElement textbox_username = driver.findElement(By.id("username"));
	public WebElement txtbox_username;
	
	@FindBy(id = "password")
	public WebElement txtbox_password;
	
	@FindBy(name = "submit")
	public WebElement btn_login;
	
}
