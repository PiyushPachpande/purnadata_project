package com.purnadata.java.customer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.purnadata.java.login.UserLogin_MainMenuCase;

public class DeleteCustomerCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.purnadata.in/PurnaDemo/index.php");

		// Login and opening Customer Option from separate class using page object model.
		UserLogin_MainMenuCase login = new UserLogin_MainMenuCase();
		login.userLoginFunction(driver);

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
