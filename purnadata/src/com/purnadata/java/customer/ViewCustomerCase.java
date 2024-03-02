package com.purnadata.java.customer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.purnadata.java.login.UserLogin_MainMenuCase;

import pageobjectmodel.LoginPageFactory;

public class ViewCustomerCase {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.purnadata.in/PurnaDemo/index.php");

		// Login Page from separate class using page object model.
		UserLogin_MainMenuCase login = new UserLogin_MainMenuCase();
		login.userLoginFunction(driver);
		
		
		// Clicking on view button of customer having name Nirbhay
		List<WebElement> tableData = driver.findElements(By.tagName("td"));

		for (int i = 0; i < tableData.size(); i++) {
			String cname = tableData.get(i).getText();

			if (cname.equals("Nirbhay")) {

				String custId = tableData.get(i - 1).getText();
				driver.findElement(By.xpath("//a[@href='view_customer.php?sr_no=" + custId + "']")).click();
				break;
			}

		}

		// Validation
		String cname = driver.findElement(By.id("customer_name")).getAttribute("value");
		if (cname.equals("Nirbhay"))
			System.out.println("Customer " + cname + " details is displayed.!!");
		else
			System.out.println("Unexpected result is displayed");

		// Closing the driver session
		driver.quit();

	}

}
