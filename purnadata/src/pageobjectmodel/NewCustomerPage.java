package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	public NewCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "sr_no")
	public WebElement textbox_custNo;

	@FindBy(id = "customer_name")
	public WebElement textbox_custName;

	@FindBy(id = "contact_no")
	public WebElement textbox_custContactNo;

	@FindBy(id = "billing_address")
	public WebElement textbox_billAddr;

	@FindBy(id = "shipping_address")
	public WebElement textbox_shipAddr;

	@FindBy(id = "email")
	public WebElement textbox_email;

	@FindBy(id = "contact_person")
	public WebElement textbox_contactPerson;

	@FindBy(id = "person_no")
	public WebElement textbox_personContactNo;
	
	@FindBy(id = "gst_no")
	public WebElement textbox_gstNo;

	@FindBy(id = "pan_no")
	public WebElement textbox_panNo;

	@FindBy(id = "vendor_code_no")
	public WebElement textbox_vendorNo;

	@FindBy(id = "btn")
	public WebElement btn_saveorUpdate;

	@FindBy(xpath = "//a[text()='Customer Details']")
	public WebElement btn_customerDetails;
	
	@FindBy(xpath = "//td[text()='1999']")
	public WebElement validationID;

	@FindBy(xpath = "//td[text()='4454ADA7DAD7']")
	public WebElement validationGST;
}
