package com.purnadata.java.employee;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteEmployeeCase {

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

		// Clicking on Delete Button
		List<WebElement> tableData = driver.findElements(By.tagName("td"));
		String toDelEmpName = "Piyush P";
		boolean flag = false;

		for (int i = 0; i < tableData.size(); i++) {
			String cname = tableData.get(i).getText();
			if (cname.equals(toDelEmpName)) {
				String custId = tableData.get(i - 1).getText();
				driver.findElement(By.xpath("//a[@href='delete_employee.php?sr_no=" + custId + "']")).click();
				driver.switchTo().alert().accept();
				flag = true;
				break;
			}

		}

		// Validation

		if (flag) {
			System.out.println("Employee " + toDelEmpName + " record is successfully deleted.!!");
		} else
			System.out.println("Unexpected result - Employee record is not deleted.");

		// Closing the driver session
		driver.quit();

	}

}
