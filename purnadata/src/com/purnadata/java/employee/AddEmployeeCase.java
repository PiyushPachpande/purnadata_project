package com.purnadata.java.employee;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddEmployeeCase {

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

		// Clicking on Add New Employee
		driver.findElement(By.name("btn_new_party")).click();

		// Filling Employee Details
		driver.findElement(By.id("sr_no")).clear();
		driver.findElement(By.id("sr_no")).sendKeys("101");
		driver.findElement(By.id("name")).sendKeys("Piyush P");
		driver.findElement(By.id("date_of_joining")).sendKeys("08/17/2021");
		driver.findElement(By.id("department")).sendKeys("IT");
		driver.findElement(By.id("designation")).sendKeys("Analyst");
		driver.findElement(By.id("mobile")).sendKeys("9998887770");
		driver.findElement(By.id("altr_cont")).sendKeys("NA");
		driver.findElement(By.id("pan_no")).sendKeys("XYZAB1259P");
		driver.findElement(By.id("email")).sendKeys("piyush@gmail.com");
		driver.findElement(By.id("area")).sendKeys("PCMC");
		driver.findElement(By.id("region")).sendKeys("Pune");
		driver.findElement(By.id("birthdate")).sendKeys("12-05-1999");
		driver.findElement(By.id("bloodgroup")).sendKeys("A+");
		driver.findElement(By.id("address")).sendKeys("PCMC, Pune");
		driver.findElement(By.id("passport")).sendKeys("NA");
		driver.findElement(By.id("emp_id")).sendKeys("1259");
		driver.findElement(By.id("bank_name")).sendKeys("HDFC");
		driver.findElement(By.id("bank_addr")).sendKeys("PCMC");
		driver.findElement(By.id("acc_no")).sendKeys("1234567890");
		driver.findElement(By.id("ifsc_code")).sendKeys("HDFC000123");
		driver.findElement(By.id("salary")).sendKeys("1200000");
		driver.findElement(By.id("no_of_days")).sendKeys("30");
		driver.findElement(By.id("total")).sendKeys("100000");

		driver.findElement(By.id("basic")).clear();
		driver.findElement(By.id("basic")).sendKeys("55000");

		driver.findElement(By.id("hra")).clear();
		driver.findElement(By.id("hra")).sendKeys("16000");

		driver.findElement(By.id("city_compo")).clear();
		driver.findElement(By.id("city_compo")).sendKeys("15000");

		driver.findElement(By.id("medical")).clear();
		driver.findElement(By.id("medical")).sendKeys("25000");

		driver.findElement(By.id("conveyance")).clear();
		driver.findElement(By.id("conveyance")).sendKeys("5000");

		driver.findElement(By.id("adhoc")).clear();
		driver.findElement(By.id("adhoc")).sendKeys("6000");

		driver.findElement(By.id("project_allo")).clear();
		driver.findElement(By.id("project_allo")).sendKeys("20000");

		driver.findElement(By.id("pf_tax")).clear();
		driver.findElement(By.id("pf_tax")).sendKeys("14000");

		// Clicking on Calculate Button
		driver.findElement(By.id("myButton")).click();

		// Clicking on Update Button
		driver.findElement(By.id("btn")).click();

		// Clicking OK on popup
		driver.switchTo().alert().accept();

		// Clicking on Employee Dashboard Button
		driver.findElement(By.xpath("//a[text()='Employee Dashboard']")).click();

		// Validation
		if (driver.findElement(By.xpath("//td[text()='Piyush P']")).isDisplayed())
			System.out.println("New Employee is successfully Created.!!");
		else
			System.out.println("Unexpected Result - New employee is not created.");

		// Closing driver session
		driver.quit();

	}

}
