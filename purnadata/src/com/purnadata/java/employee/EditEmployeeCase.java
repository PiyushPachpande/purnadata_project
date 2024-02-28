package com.purnadata.java.employee;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditEmployeeCase {

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
		
		//Clicking on Edit Button
		driver.findElement(By.xpath("//a[@href='edit_employee.php?sr_no=101']")).click();

		//Editing Designation and Joining Date
		driver.findElement(By.id("date_of_joining")).clear();
		driver.findElement(By.id("date_of_joining")).sendKeys("10/17/2022");

		driver.findElement(By.id("designation")).clear();
		driver.findElement(By.id("designation")).sendKeys("Senior Analyst");
		
		// Clicking on Update Button
		driver.findElement(By.id("btn")).click();
		
		// Clicking OK on popup
		driver.switchTo().alert().accept();

		//Validation
		
		WebElement empName = driver.findElement(By.xpath("//td[text()='Piyush P']"));
		WebElement empDesig = driver.findElement(By.xpath("//td[text()='Senior Analyst']"));

		
		if (empName.isDisplayed() && empDesig.isDisplayed())
			System.out.println("Employee Joining Date and Designation is successfully Created.!!");
		else
			System.out.println("Unexpected Result - Employee details is not updated.");

		// Closing driver session
		driver.quit();
		
	}

}
