package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDashboardPage {

	public CustomerDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (name = "btn_new_party")
	
	public WebElement btn_newCustomer;
	
	@FindBy (xpath = "//a[@href='edit_customer.php?sr_no=11']")
	public WebElement btn_edit;
	
	@FindBy (xpath = "//a[@href='view_customer.php?sr_no=11']")
	public WebElement btn_view;
	
	@FindBy (xpath = "//a[@href='delete_customer.php?sr_no=11']")
	public WebElement btn_delete;

}
