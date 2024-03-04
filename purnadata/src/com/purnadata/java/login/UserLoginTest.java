package com.purnadata.java.login;

import org.openqa.selenium.WebDriver;

import pageobjectmodel.LoginPage;

public class UserLoginTest {

	public void userLoginFunction(WebDriver driver) {

		LoginPage objLogin = new LoginPage(driver);
		
		// Enter Username
		objLogin.txtbox_username.sendKeys("admin");
		
		// Enter Password
		objLogin.txtbox_password.sendKeys("admin");
		
		// Clicking on Login Button
		objLogin.btn_login.click();
		

	}

}
