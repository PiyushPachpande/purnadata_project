package com.purnadata.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditCustomerCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.purnadata.in/PurnaDemo/index.php");

		// Login Page
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Clicking on Main
		driver.findElement(By.xpath("//span[contains(text(),'Main')]")).click();

		// Selecting Customer from Main menu
		driver.findElement(By.xpath("//a[@href='customer_dashboard.php']")).click();

		// Clicking on edit button
		driver.findElement(By.xpath("//a[@href='edit_customer.php?sr_no=12345']")).click();

		// Editing Customer Name and GST number
		driver.findElement(By.id("customer_name")).clear();
		driver.findElement(By.id("customer_name")).sendKeys("Krishna");

		driver.findElement(By.id("gst_no")).clear();
		driver.findElement(By.id("gst_no")).sendKeys("99OAPPA016ZZ1Z843");

		// Clicking on Update button
		driver.findElement(By.id("btn")).click();

		// Clicking Ok on popup
		driver.switchTo().alert().accept();

		// Validation
		if (driver.findElement(By.xpath("//td[text()='Krishna']")).isDisplayed()) {
			System.out.println("Customer details is successfully Edited.!!");
		}

		// Closing the driver session
		driver.quit();

	}

}
