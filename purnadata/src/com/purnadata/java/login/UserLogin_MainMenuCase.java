package com.purnadata.java.login;

import org.openqa.selenium.WebDriver;

import pageobjectmodel.LoginPageOjectModel;
import pageobjectmodel.LoginPageFactory;

public class UserLogin_MainMenuCase {

	public void userLoginFunction(WebDriver driver) {

		LoginPageOjectModel loginPage = new LoginPageOjectModel(driver);
		LoginPageFactory objLoginPageF = new LoginPageFactory(driver);


		// Entering Username
		objLoginPageF.enterUsername("admin");
		
		// Entering password
		objLoginPageF.enterPassword("admin");

		// Clicking on Login Button
		objLoginPageF.clickLogin();

		// Clicking on Main
		objLoginPageF.openMainMenu(); // driver.findElement(By.xpath("//span[contains(text(),'Main')]")).click();

		// Selecting Customer from Main menu
		objLoginPageF.selectCustomerOption(); // driver.findElement(By.xpath("//a[@href='customer_dashboard.php']")).click();

	}

}
