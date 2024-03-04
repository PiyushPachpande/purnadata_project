package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Main Menu Dropdown
	@FindBy(xpath = "//span[contains(text(),'Main')]")      
	public WebElement link_main;
	
	// Selecting Purchase Option from Main Menu
	@FindBy(xpath = "//a[@href='purchase_item_dashboard.php']")      
	public WebElement link_inventory;	
	
	// Selecting Customer Option from Main Menu
	@FindBy (xpath = "//a[@href='customer_dashboard.php']")
	public WebElement link_customer;
	
	// Selecting Employee Option from Main Menu
	@FindBy (xpath = "//a[@href='employee_dashboard.php']")
	public WebElement link_employee;
	
	// Selecting Sales Option from Main Menu
	@FindBy (xpath = "//a[@href='sale_dashboard.php']")
	public WebElement link_s;
	
}
