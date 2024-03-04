package com.purnadata.java.customer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.purnadata.java.login.UserLoginTest;

import pageobjectmodel.CustomerDashboardPage;
import pageobjectmodel.DashboardPage;
import pageobjectmodel.LoginPage;
import pageobjectmodel.NewCustomerPage;

public class NewCustomerCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.purnadata.in/PurnaDemo/index.php");

		// Login Page from separate class using page object model.
		LoginPage login = new LoginPage(driver);
		login.txtbox_username.sendKeys("admin");
		login.txtbox_password.sendKeys("admin");
		login.btn_login.click();

		//Clicking on Main menu dropdown
		DashboardPage dashboard = new DashboardPage(driver);
		dashboard.link_main.click();
		dashboard.link_customer.click();
		
		// Clicking on New Customer
		CustomerDashboardPage custDash = new CustomerDashboardPage(driver);
		custDash.btn_newCustomer.click();

		// Filling Customer details
		NewCustomerPage newCustomer = new NewCustomerPage(driver);
		newCustomer.textbox_custNo.clear();
		newCustomer.textbox_custNo.sendKeys("2000");
		newCustomer.textbox_custName.sendKeys("Virat");
		newCustomer.textbox_custContactNo.sendKeys("9876543210");
		newCustomer.textbox_billAddr.sendKeys("Chinchwad");
		newCustomer.textbox_shipAddr.sendKeys("Pune");
		newCustomer.textbox_email.sendKeys("xyz@gmail.com");
		newCustomer.textbox_contactPerson.sendKeys("Kohli");
		newCustomer.textbox_personContactNo.sendKeys("9812345670");
		newCustomer.textbox_gstNo.sendKeys("1223ADAA65AD5");
		newCustomer.textbox_panNo.sendKeys("ABCDE9912Z");
		newCustomer.textbox_vendorNo.sendKeys("ABC101");

		// Saving filled details
		newCustomer.btn_saveorUpdate.click();
		
		// Clicking OK on popup
		driver.switchTo().alert().accept();

		// Clicking on Customer Details Button
		newCustomer.btn_customerDetails.click();
		
		// Validation
		if (newCustomer.validationID.isDisplayed()) {
			System.out.println("New Customer details is successfully added.!!");
		}

		// Closing the driver session
		driver.quit();

	}

}
