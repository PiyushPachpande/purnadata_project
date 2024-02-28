package com.purnadata.java.customer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCustomerCase {

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

		// Clicking on delete button to delete record of customer Nikhil
		List<WebElement> tableData = driver.findElements(By.tagName("td"));
		String toDelCustName = "Nikhil";
		boolean flag = false;

		for (int i = 0; i < tableData.size(); i++) {
			String cname = tableData.get(i).getText();
			if (cname.equals(toDelCustName)) {
				String custId = tableData.get(i - 1).getText();
				driver.findElement(By.xpath("//a[@href='delete_customer.php?sr_no=" + custId + "']")).click();
				driver.switchTo().alert().accept();
				flag = true;
				break;
			}

		}

		// Validation

		if (flag) {
			System.out.println("Customer " + toDelCustName + " record is successfully deleted.!!");
		} else
			System.out.println("Unexpected result - Customer record is not deleted.");

		// Closing the driver session
		driver.quit();
	}

}
