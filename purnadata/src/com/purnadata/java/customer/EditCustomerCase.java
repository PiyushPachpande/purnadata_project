package com.purnadata.java.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.purnadata.java.login.UserLoginTest;

import pageobjectmodel.CustomerDashboardPage;
import pageobjectmodel.DashboardPage;
import pageobjectmodel.LoginPage;
import pageobjectmodel.NewCustomerPage;

public class EditCustomerCase {

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

		// Clicking on Edit Customer
		CustomerDashboardPage custDash = new CustomerDashboardPage(driver);
		custDash.btn_edit.click();

		// Editing Customer Pan and GST number
		NewCustomerPage newCustElement = new NewCustomerPage(driver);
		newCustElement.textbox_gstNo.clear();
		newCustElement.textbox_gstNo.sendKeys("4454ADA7DAD7");
		
		newCustElement.textbox_panNo.clear();
		newCustElement.textbox_panNo.sendKeys("LMNO1234Y");

		// Clicking on Update button
		newCustElement.btn_saveorUpdate.click();
		
		// Clicking Ok on popup
		driver.switchTo().alert().accept();

		// Validation
		if (newCustElement.validationGST.isDisplayed()) {
			System.out.println("Customer details is successfully Edited.!!");
		}

		// Closing the driver session
		driver.quit();

	}

}
