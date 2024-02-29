package com.purnadata.java.sales;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewSalesInoviceCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.purnadata.in/PurnaDemo/index.php");

		// Login Page
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Clicking on Sales
		driver.findElement(By.xpath("//span[contains(text(),'Sales')]")).click();

		// Selecting Sales Invoice from Sales Menu
		driver.findElement(By.xpath("//a[@href='sale_dashboard.php']")).click();

		// Clicking on View Button
		driver.findElement(By.xpath("//a[@href='view_sale_invoice.php?invoice_no=101']")).click();

		// Validation
		String invoicNo = driver.findElement(By.id("invoice_no")).getAttribute("value");

		if (invoicNo.equals("101"))
			System.out.println("Inovice details of Krishna is displayed");
		else
			System.out.println("Unexpected Result - Sales Invoice details is not displayed");

		// Ending WebDriver session
		driver.quit();

	}

}
