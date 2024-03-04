package com.purnadata.java.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjectmodel.CustomerDashboardPage;
import pageobjectmodel.DashboardPage;
import pageobjectmodel.LoginPage;
import pageobjectmodel.NewCustomerPage;

public class ViewCustomerCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.purnadata.in/PurnaDemo/index.php");

		// Login Page from separate class using page object model.
		LoginPage login = new LoginPage(driver);
		login.txtbox_username.sendKeys("admin");
		login.txtbox_password.sendKeys("admin");
		login.btn_login.click();

		// Clicking on Main menu dropdown
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.link_main.click();
		dashboard.link_customer.click();

		// Clicking on View Customer
		CustomerDashboardPage custDash = new CustomerDashboardPage(driver);
		custDash.btn_view.click();

		// Validation
		NewCustomerPage newCustElement = new NewCustomerPage(driver);
		String cname = newCustElement.textbox_custName.getAttribute("value");
		if (cname.equals("Sandy"))
			System.out.println("Customer " + cname + " details is displayed.!!");
		else
			System.out.println("Unexpected result is displayed");

		// Closing the driver session
		driver.quit();

	}

}
