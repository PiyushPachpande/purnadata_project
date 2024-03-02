package com.purnadata.java.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.purnadata.java.login.UserLogin_MainMenuCase;

public class NewCustomerCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.purnadata.in/PurnaDemo/index.php");

		// Login Page from separate class using page object model.
		UserLogin_MainMenuCase login = new UserLogin_MainMenuCase();
		login.userLoginFunction(driver);

		// Clicking on New Customer
		driver.findElement(By.name("btn_new_party")).click();

		// Filling Customer details
		driver.findElement(By.name("sr_no")).clear();
		driver.findElement(By.name("sr_no")).sendKeys("123458");
		driver.findElement(By.name("customer_name")).sendKeys("Piyush");
		driver.findElement(By.name("contact_no")).sendKeys("9988776655");
		driver.findElement(By.name("billing_address")).sendKeys("PCMC, Pune");
		driver.findElement(By.name("check")).click();
		driver.findElement(By.name("email")).sendKeys("piyush@gmail.com");
		driver.findElement(By.name("contact_person")).sendKeys("Ariyan");
		driver.findElement(By.name("person_no")).sendKeys("8208201259");
		driver.findElement(By.name("gst_no")).sendKeys("27VAFFA0167Z2Z8");
		driver.findElement(By.name("pan_no")).sendKeys("FBQAA125X");
		driver.findElement(By.name("vendor_code_no")).sendKeys("125");

		// Saving filled details
		driver.findElement(By.xpath("//button[@id='btn']")).click();

		// Clicking OK on popup
		driver.switchTo().alert().accept();

		// Clicking on Customer Details Button
		driver.findElement(By.xpath("//a[@class='btn btn-success btn-fill']")).click();

		// Validation
		if (driver.findElement(By.xpath("//td[text()='12345']")).isDisplayed()) {
			System.out.println("New Customer details is successfully added.!!");
		}

		// Closing the driver session
		driver.quit();

	}

}
