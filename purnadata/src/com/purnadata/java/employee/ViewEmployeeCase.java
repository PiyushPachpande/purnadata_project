package com.purnadata.java.employee;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewEmployeeCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.purnadata.in/PurnaDemo/index.php");

		// Login Page
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Clicking on Main
		driver.findElement(By.xpath("//span[contains(text(),'Main')]")).click();

		// Selecting Employee from Main menu
		driver.findElement(By.xpath("//a[@href='employee_dashboard.php']")).click();

		// Clicking on View Button
		driver.findElement(By.xpath("//a[@href='view_employee.php?sr_no=101']")).click();

		// Validation
		String empId = driver.findElement(By.id("emp_id")).getAttribute("value");
		String empName = driver.findElement(By.id("name")).getAttribute("value");

		if (empId.equals("1259") && empName.equals("Piyush P"))
			System.out.println("Employee details is successfully displayed");
		else
			System.out.println("Unexpected Result - Employee details is not displayed");

		// Closing driver session
		driver.quit();

	}

}
